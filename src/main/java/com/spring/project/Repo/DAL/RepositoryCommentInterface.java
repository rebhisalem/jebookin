package com.spring.project.Repo.DAL;

import com.spring.project.Data.Comment;

public interface RepositoryCommentInterface {
	public void add(Comment obj);
    public Comment find(String id);
    public void delete(Comment obj);
    public void update(Comment obj);

}
