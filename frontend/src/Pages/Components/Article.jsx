import React, { useEffect, useState } from 'react'
import { Link, Outlet } from 'react-router-dom';


const Article = ({ article }) => {
  return (
    <Link to={article.url} target="_blank" rel="noopener noreferrer">
      <article className="article-card">
        {article.urlToImage ?
          <div className="article-image" style={{
            "background": `url(${article?.urlToImage}) center/cover no-repeat`,
            'backgroundSize': 'cover'
          }}>
          </div> :
          <div className="article-image" style={{
            display: "flex",
            justifyContent: "center",
          }}>
            <img src='no-image-icon-23483.png' alt='noImage'/>
          </div>}
        <div className="article-content">
          <div className="article-date-author">
            <span>{article.publishedAt.slice(0, 10)}</span>
            <span> · </span>
            <span>{article.author}</span>
          </div>
          <h2 className="article-title">{article.title}</h2>
        </div>
      </article>
    </Link >
  )
}

export default Article