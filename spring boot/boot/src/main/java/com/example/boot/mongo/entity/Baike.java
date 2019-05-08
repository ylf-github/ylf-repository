package com.example.boot.mongo.entity;

import java.util.Date;

public class Baike {
        private String id;
        private String desc;
        private Comment comment;
        private Date date;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
		public Comment getComment() {
			return comment;
		}
		public void setComment(Comment comment) {
			this.comment = comment;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
        
}
