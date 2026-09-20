import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BrowserGUI extends JFrame {

    private final Browser browser;

    private JLabel lblSiteName;
    private JLabel lblSiteUrl;
    private JLabel lblAddress;
    private JLabel lblHistory;

    // NEW
    private JLabel lblCurrentFavicon;
    private JLabel lblScreenshot;

    private JButton btnBack;
    private JButton btnForward;

    // ---------- COLORS ----------
    private final Color BACKGROUND = new Color(18, 18, 22);
    private final Color SURFACE = new Color(28, 28, 34);
    private final Color SURFACE_LIGHT = new Color(38, 38, 46);
    private final Color TEXT = new Color(240, 240, 245);
    private final Color MUTED = new Color(155, 155, 165);

    public BrowserGUI() {
        browser = new Browser();

        setTitle("Simple Browser");
        setSize(1000, 700);
        setMinimumSize(new Dimension(850, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setBackground(BACKGROUND);
        setLayout(new BorderLayout());

        add(createNavigationBar(), BorderLayout.NORTH);
        add(createMainContent(), BorderLayout.CENTER);
        add(createHistoryPanel(), BorderLayout.SOUTH);

        updateUI();

        setVisible(true);
    }

    // =========================================================
    // NAVIGATION BAR
    // =========================================================

    private JPanel createNavigationBar() {

        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBackground(SURFACE);
        wrapper.setBorder(new EmptyBorder(12, 18, 12, 18));

        JPanel buttons = new JPanel(
                new FlowLayout(FlowLayout.LEFT, 8, 0)
        );
        buttons.setOpaque(false);

        btnBack = createNavigationButton("←");
        btnForward = createNavigationButton("→");

        btnBack.addActionListener(e -> {
            browser.back();
            updateUI();
        });

        btnForward.addActionListener(e -> {
            browser.forward();
            updateUI();
        });

        buttons.add(btnBack);
        buttons.add(btnForward);

        lblAddress = new JLabel("New Tab");
        lblAddress.setForeground(MUTED);
        lblAddress.setFont(
                new Font("SansSerif", Font.PLAIN, 14)
        );
        lblAddress.setBorder(
                new EmptyBorder(0, 18, 0, 0)
        );

        wrapper.add(buttons, BorderLayout.WEST);
        wrapper.add(lblAddress, BorderLayout.CENTER);

        return wrapper;
    }

    private JButton createNavigationButton(String text) {
        JButton button = new JButton(text);

        button.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 22));
        button.setForeground(TEXT);
        button.setBackground(SURFACE_LIGHT);

        button.setFocusPainted(false);
        button.setBorderPainted(false);

        button.setMargin(new Insets(0, 0, 0, 0));

        button.setPreferredSize(new Dimension(48, 40));
        button.setMinimumSize(new Dimension(48, 40));

        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return button;
    }

    // =========================================================
    // MAIN CONTENT
    // =========================================================

    private JPanel createMainContent() {

        JPanel main = new JPanel();

        main.setBackground(BACKGROUND);
        main.setLayout(
                new BoxLayout(main, BoxLayout.Y_AXIS)
        );

        main.setBorder(
                new EmptyBorder(25, 50, 25, 50)
        );

        // ---------- FAVICON ----------

        lblCurrentFavicon = new JLabel();
        lblCurrentFavicon.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        // ---------- SITE NAME ----------

        lblSiteName = new JLabel("New Tab");

        lblSiteName.setForeground(TEXT);
        lblSiteName.setFont(
                new Font("SansSerif", Font.BOLD, 32)
        );

        lblSiteName.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        // ---------- URL ----------

        lblSiteUrl = new JLabel(
                "Choose a website to visit"
        );

        lblSiteUrl.setForeground(MUTED);
        lblSiteUrl.setFont(
                new Font("SansSerif", Font.PLAIN, 14)
        );

        lblSiteUrl.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        // ---------- SCREENSHOT ----------

        lblScreenshot = new JLabel();

        lblScreenshot.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        lblScreenshot.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        lblScreenshot.setPreferredSize(
                new Dimension(600, 260)
        );

        // ---------- ADD CURRENT SITE ----------

        main.add(Box.createVerticalGlue());
        main.add(lblScreenshot);
        main.add(Box.createVerticalGlue());

        main.add(Box.createVerticalStrut(20));

        main.add(Box.createVerticalStrut(20));

        // ---------- QUICK ACCESS ----------

        JLabel chooseLabel = new JLabel("QUICK ACCESS");

        chooseLabel.setForeground(MUTED);
        chooseLabel.setFont(
                new Font("SansSerif", Font.BOLD, 12)
        );

        chooseLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        main.add(chooseLabel);
        main.add(Box.createVerticalStrut(12));

        JPanel sitePanel = new JPanel(
                new FlowLayout(
                        FlowLayout.CENTER,
                        12,
                        0
                )
        );

        sitePanel.setOpaque(false);

        sitePanel.add(
                createSiteButton(
                        "Google",
                        "google.com",
                        "SimpleBrowser/assets/favicon/google.png",
                        "SimpleBrowser/assets/screenshot/SS_Google.png"
                )
        );

        sitePanel.add(
                createSiteButton(
                        "YouTube",
                        "youtube.com",
                        "SimpleBrowser/assets/favicon/youtube.png",
                        "SimpleBrowser/assets/screenshot/SS_Youtube.png"
                )
        );

        sitePanel.add(
                createSiteButton(
                        "GitHub",
                        "github.com",
                        "SimpleBrowser/assets/favicon/github.png",
                        "SimpleBrowser/assets/screenshot/SS_Github.png"
                )
        );

        sitePanel.add(
                createSiteButton(
                        "Facebook",
                        "facebook.com",
                        "SimpleBrowser/assets/favicon/facebook.png",
                        "SimpleBrowser/assets/screenshot/SS_Fesnuk.png"
                )
        );

        sitePanel.add(
                createSiteButton(
                        "X",
                        "twitter.com",
                        "SimpleBrowser/assets/favicon/X.png",
                        "SimpleBrowser/assets/screenshot/SS_X.png"
                )
        );

        main.add(sitePanel);

        return main;
    }

    // =========================================================
    // SITE BUTTON
    // =========================================================

    private JButton createSiteButton(
            String name,
            String url,
            String favicon,
            String picture
    ) {

        JButton button = new JButton(name);

        ImageIcon icon = loadImage(
                favicon,
                28,
                28
        );

        if (icon != null) {
            button.setIcon(icon);
        }

        button.setHorizontalTextPosition(
                SwingConstants.CENTER
        );

        button.setVerticalTextPosition(
                SwingConstants.BOTTOM
        );

        button.setIconTextGap(7);

        button.setForeground(TEXT);
        button.setBackground(SURFACE);

        button.setFont(
                new Font("SansSerif", Font.PLAIN, 13)
        );

        button.setPreferredSize(
                new Dimension(125, 80)
        );

        button.setFocusPainted(false);
        button.setBorderPainted(false);

        button.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        button.addActionListener(
                e -> visit(
                        name,
                        url,
                        favicon,
                        picture
                )
        );

        return button;
    }

    // =========================================================
    // HISTORY
    // =========================================================

    private JPanel createHistoryPanel() {

        JPanel panel = new JPanel(
                new BorderLayout()
        );

        panel.setBackground(SURFACE);

        panel.setBorder(
                new EmptyBorder(16, 24, 16, 24)
        );

        JLabel title = new JLabel("HISTORY");

        title.setForeground(MUTED);
        title.setFont(
                new Font("SansSerif", Font.BOLD, 11)
        );

        lblHistory = new JLabel();

        lblHistory.setForeground(TEXT);
        lblHistory.setFont(
                new Font("SansSerif", Font.PLAIN, 13)
        );

        panel.add(title, BorderLayout.NORTH);
        panel.add(lblHistory, BorderLayout.CENTER);

        return panel;
    }

    // =========================================================
    // BROWSER INTERACTION
    // =========================================================

    private void visit(
            String name,
            String url,
            String favicon,
            String picture
    ) {

        Situs situs = new Situs(
                url,
                name,
                favicon,
                picture
        );

        Node node = new Node(situs);

        browser.visit(node);

        updateUI();
    }

    // =========================================================
    // UPDATE GUI
    // =========================================================

    private void updateUI() {

        Situs current = browser.getCurrent();

        // URL di navigation bar
        lblAddress.setText(current.alamatSitus);

        // ---------- SCREENSHOT ----------

        if (current.picture != null) {

            ImageIcon screenshot = loadImage(
                    current.picture,
                    640,
                    360
            );

            lblScreenshot.setIcon(screenshot);

        } else {
            lblScreenshot.setIcon(null);
        }

        updateHistory();

        btnBack.setEnabled(
                browser.current != browser.head
        );

        btnForward.setEnabled(
                browser.current != browser.tail
        );
    }

    // =========================================================
    // IMAGE LOADER
    // =========================================================

    private ImageIcon loadImage(String path, int width, int height) {
        if (path == null) {
            return null;
        }

        ImageIcon original = new ImageIcon(path);

        if (original.getIconWidth() <= 0) {
            System.out.println("Failed to load image: " + path);
            return null;
        }

        Image scaled = original
                .getImage()
                .getScaledInstance(
                        width,
                        height,
                        Image.SCALE_SMOOTH
                );

        return new ImageIcon(scaled);
    }

    // =========================================================
    // HISTORY VISUALIZATION
    // =========================================================

    private void updateHistory() {

        StringBuilder history =
                new StringBuilder();

        Node temp = browser.head;

        while (temp != null) {

            if (temp == browser.current) {

                history.append(
                        "<b>[ "
                                + temp.data.namaSitus
                                + " ]</b>"
                );

            } else {

                history.append(
                        temp.data.namaSitus
                );
            }

            if (temp.next != null) {
                history.append("  ↔  ");
            }

            temp = temp.next;
        }

        lblHistory.setText(
                "<html>"
                        + history
                        + "</html>"
        );
    }
}