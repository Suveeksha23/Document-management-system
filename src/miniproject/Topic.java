/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;

/**
 *
 * 
 */
public class Topic {
    private int topicId;
    private String topicName;
    private String folderPath;

    public Topic(int topicId, String topic, String folderPath) {
        this.topicId = topicId;
        this.topicName = topic;
        this.folderPath = folderPath;
    }

    public int getTopicId() {
        return topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public void setTopicName(String topic) {
        this.topicName = topic;
    }

    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
    }
    
}
