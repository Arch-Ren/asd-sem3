public class Main {
    static void main(String[] args) {
        Situs google = new Situs("google.com", "Google");
        Situs youtube = new Situs("youtube.com", "Youtube");
        Situs github = new Situs("github.com", "Github");
        Situs facebook = new Situs("facebook.com", "Facebook");
        Situs twitter = new Situs("twitter.com", "Twitter");

        Node googleNode = new Node(google);
        Node youtubeNode = new Node(youtube);
        Node githubNode = new Node(github);
        Node facebookNode = new Node(facebook);
        Node twitterNode = new Node(twitter);

        Browser browser = new Browser();

        System.out.println(browser.current.data.namaSitus);

        browser.visit(googleNode);
        browser.visit(youtubeNode);
        browser.visit(githubNode);
        browser.visit(facebookNode);
        browser.back();
        browser.back();
        browser.forward();
        browser.visit(twitterNode);

        browser.showHistory();
    }
}