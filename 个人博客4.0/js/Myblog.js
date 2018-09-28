/*
  js文件
*/

// <!-- 通过点击事件，将导航栏菜单的.class 修改为“active” -->
$(function() {
  $("#nav-menu li").click(function() {
    $(this).siblings('li').removeClass('active'); // 筛选出一个li集合，全部移除.class active
    $(this).addClass('active'); // 对当前li添加 .class active
  });
});


// 搜索框搜索结果跳转到百度
function SearchClick() {
    var value = document.getElementById("Search").value;
    console.log(value);
    var URL = "https://www.baidu.com/s?wd=" + value;
    window.open(URL);         // s代表搜索，wd代表word
}
