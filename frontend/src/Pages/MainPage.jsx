import React, { useEffect, useState } from 'react'
import Loading from './Loading';
import "./MainPage.css"
import Article from './Components/Article';
import "./MainPage.css"

const API_KEY = "8462a07817474378ba4605459a02a170"
const AMOUNT = 4;


const fetchNews = async () => {
  try {
    const res = await fetch(`https://newsapi.org/v2/top-headlines?country=us&category=science&apiKey=${API_KEY}`);
    const data = await res.json();
    return data.articles
  } catch (error) {
    console.error("Error fetching student data: ", error)
  }
}

const MainPage = () => {
  const [loading, setLoading] = useState(true)
  const [news, setNews] = useState(null)

  useEffect(() => {
    fetchNews()
      .then((fetchedNews) => {
        console.log(fetchedNews)
        setNews(fetchedNews)
        setLoading(false)
      })
  }, [])

  const generateRandomNum = (border) => {
    return Math.floor(Math.random() * border)
  }

  function getRandomElements(numElements) {
    const copyArray = news.slice();
    const randomElements = [];

    for (let i = 0; i < numElements; i++) {
      let randomIndex = generateRandomNum(copyArray.length);
      while (copyArray[randomIndex].title === "[Removed]") {
        randomIndex = generateRandomNum(copyArray.length);
      }
      randomElements.push(copyArray[randomIndex]);
      copyArray.splice(randomIndex, 1);
    }
    return randomElements;
  }



  return loading ?
    <Loading /> : (
      <div className='article-list'>
        {news && getRandomElements(AMOUNT).map((newsArticle, index) => (
          <div key={index}>
            <Article article={newsArticle} />
          </div>
        ))}
      </div>
    )
}

export default MainPage;