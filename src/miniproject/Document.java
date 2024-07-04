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
public class Document {
    private int categoryId;
    private int topicId;
    private int documentId;
    private Tag documentTags;
    private String documentName;

    public Document(int categoryId, int topicId, int documentId, Tag documentTags, String fileName) {
        this.categoryId = categoryId;
        this.topicId = topicId;
        this.documentId = documentId;
        this.documentTags = documentTags;
        this.documentName= fileName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getTopicId() {
        return topicId;
    }

    public int getDocumentId() {
        return documentId;
    }

    public Tag getDocumentTags() {
        return documentTags;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public void setDocumentTags(Tag documentTags) {
        this.documentTags = documentTags;
    }

    public void setDocumentName(String fileName) {
        this.documentName = fileName;
    }
    
    
}
