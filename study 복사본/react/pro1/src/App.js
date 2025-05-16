import logo from './logo.svg';
import './App.css';
import { useState } from 'react';

function App() {

  let post = '강남 우동 맛집';
  //보관할 자료 넣을때 쓰는 문법 
  //a 는 state에 보관했던 자료, b는 state변경 도와주는 함수
  //State는 쓰면, html은 자동으로 전체 랜더링 됨.
  let [글제목, b] = useState('남자 코트 추천')
  let [글제목2, e] = useState('강남 우동 맛집')
  let [글제목3, f] = useState('파이썬독학')

  let [title, setTitle] = useState('blog')

  //destructuring 문법
  //a -> 1, c-> 2
  let [a,c] = [1,2];

  return (
    <div className="App">
      <div className = "black-nav">
        <h4 style = {{color : 'red', fontSize : '16px'}}>{ title }</h4>
      </div>
      <div className = "list">
        <h4>{ 글제목 }</h4>
        <p>5월 16일 발행</p>
      </div>

      <div className = "list">
        <h4>{ 글제목2 }</h4>
        <p>5월 16일 발행</p>
      </div>

      <div className = "list">
        <h4>{ 글제목3 }</h4>
        <p>5월 16일 발행</p>
      </div>
    </div>
  );
}

export default App;
