import { Component } from "preact";
import { useState, useEffect } from "preact/hooks";

//code.iamkate.com
// function Queue(){
//   var a=[],b=0;
//   this.getLength=function(){return a.length-b};
//   this.isEmpty=function(){return 0==a.length};
//   this.enqueue=function(b){a.push(b)};
//   this.dequeue=function(){if(0!=a.length){var c=a[b];2*++b>=a.length&&(a=a.slice(b),b=0);return c}};
//   this.peek=function(){return 0<a.length?a[b]:void 0}
//   this.get = () => a
// };

// function Queue(){
//   var a=[],b=0;
//   this.getLength=function(){return a.length-b};
//   this.isEmpty=function(){return 0==a.length};
//   this.enqueue=function(b){a.push(b)};
//   this.dequeue=function(){a.shift()};
//   this.peek=function(){return 0<a.length?a[b]:void 0}
//   this.get = () => a
// };

const generateUUID = () => { // Public Domain/MIT
  var d = new Date().getTime();//Timestamp
  var d2 = (performance && performance.now && (performance.now()*1000)) || 0;//Time in microseconds since page-load or 0 if unsupported
  return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
      var r = Math.random() * 16;//random number between 0 and 16
      if(d > 0){//Use timestamp until depleted
          r = (d + r)%16 | 0;
          d = Math.floor(d/16);
      } else {//Use microseconds since page-load if supported
          r = (d2 + r)%16 | 0;
          d2 = Math.floor(d2/16);
      }
      return (c === 'x' ? r : (r & 0x3 | 0x8)).toString(16);
  });
}

// const animationTimeout = 3000;

// export const FadeContent = (props) => {
//   const {initialContent, newContent} = props;
//   const [content, setContent] = useState([<div id={initialContent.props.children} key={generateUUID()} class="fadeIn">{initialContent}</div>]);

//   if(props.newContent) {
//     setContent(prev=>{
//       console.log({1:prev})
//       prev.push(<div id={newContent.props.children} key={generateUUID()} class="fadeIn">{newContent}</div>);
//       console.log({2:prev})
//       prev.map((val, i, a) => {if(i===a.length-1)return val; val.props.class="fadeOut"; return val});
//       console.log({3:prev})
//       return prev;
//     })
//     //this.content.map((val, i, a) => {if(i===a.length-1)return; return val.props.class="fadeOut"});
//     //setTimeout(()=>{setContent(prev=>{prev.shift(); return prev})}, animationTimeout);
//   }

//   console.log(
//     content.map(
//       (a)=>{return{id: a.props.id, class: a.props.class}
//       }
//     )
//   );
//   return (
//     <div id="fade-content-wrapper">
//       {content}
//     </div>
//   )
// }