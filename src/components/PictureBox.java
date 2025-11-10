package components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;

public class PictureBox extends JLayeredPane {

    private Icon image;
    private boolean autoSize = true;

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
        repaint();
    }

    public boolean isAutoSize() {
        return autoSize;
    }

    public void setAutoSize(boolean autoSize) {
        this.autoSize = autoSize;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        if (image != null) {
            Graphics2D g2 = (Graphics2D) grphcs;
            Rectangle size = getAutoSize(image);
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(toImage(image),
                    size.getLocation().x,
                    size.getLocation().y,
                    size.getSize().width,
                    size.getSize().height,
                    null);
        }
    }

    private Rectangle getAutoSize(Icon icon) {
        int w = getWidth();
        int h = getHeight();
        int iw = icon.getIconWidth();
        int ih = icon.getIconHeight();

        if (!autoSize) {
            int x = (w - iw) / 2;
            int y = (h - ih) / 2;
            return new Rectangle(new Point(x, y), new Dimension(iw, ih));
        } else {
            double scaleX = (double) w / iw;
            double scaleY = (double) h / ih;
            double scale = Math.min(scaleX, scaleY);

            int newW = (int) (iw * scale);
            int newH = (int) (ih * scale);
            int x = (w - newW) / 2;
            int y = (h - newH) / 2;

            return new Rectangle(new Point(x, y), new Dimension(newW, newH));
        }
    }

    private Image toImage(Icon icon) {
        if (icon instanceof ImageIcon) {
            return ((ImageIcon) icon).getImage();
        } else {
            return new ImageIcon(icon.toString()).getImage();
        }
    }
}

