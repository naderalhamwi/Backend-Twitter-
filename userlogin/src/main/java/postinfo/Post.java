/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postinfo;

/**
 *
 * @author Elev
 */
public class Post {
    public String title;
    public int likes;
    public String content;
    public String EmailUsername;

    public Post() {
    }

    public Post(String title, int likes, String content, String EmailUsername) {
        this.title = title;
        this.likes = likes;
        this.content = content;
        this.EmailUsername = EmailUsername;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmailUsername() {
        return EmailUsername;
    }

    public void setEmailUsername(String EmailUsername) {
        this.EmailUsername = EmailUsername;
    }
}
