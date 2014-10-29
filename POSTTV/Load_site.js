//load posttv site

describe('PostTV Home Page', function() {
  it('Load the site', function() {
  
   browser.driver.get('http://www.washingtonpost.com/posttv/');
   
    
});
});
describe('Verify Title of Home Page',function(){
it('Verify the correct tile is shown above the video',function()
{
var VideoTitle=browser.driver.findElement(By.xpath(".//*[@id='video-header-module-container']/div[3]/div[1]/h2"));
expect(VideoTitle.getText()).toEqual('Crew cleans Tex. home where Ebola patient stayed');
});
});

describe('Navigate to the video in the page',function()
{
	it('Naviage to the video in the page',function(){
		browser.executeScript('window.scrollTo(0,0);').then(function () {
    //page.saveButton.click();
});
	/* var video_screen= browser.driver.findElement(by.xpath(".//*[@id='canvas']"));
    video_screen.click();

var scrollIntoView = function () 
{
  arguments[0].scrollIntoView();
};
browser.executeScript(scrollIntoView, video_screen);*/
});
});
describe('Verify the video date and time',function(){
	it('verify that the video date and time is displayed',function(){
	var filter = browser.driver.findElement(by.xpath(".//*[@id='video-details-module-container']/div[1]/div[1]/p/span[1]"));

filter.click();
expect(filter.getText()).toEqual('October 4, 2014 9:11 AM EDT');	
});
});


describe('Verify that the video is started',function(){
it('Verify that the video is started',function()
{
	  V_scroll=by.xpath(".//*[@id='player-container-posttv-video-template']/div/div/div[6]/div[1]/div/div[1]/div[3]/div");
 	//var videoContainer = browser.driver.findElement(by.css('#video-player-container'));
 	//browser.driver.actions().mouseMove(V_scroll).perform();

 	browser.driver.wait(function(){ 
    
   // expect(V_scroll).toBe(false);
    return browser.driver.isElementPresent(V_scroll);
}, 2000000); 
});

});
describe('Pause the video',function() {
it('Verify that video is stopped playing',function() {
	//WebDriverWait wait = new WebDriverWait(webDriver, 2000);
        var videoContainer = browser.driver.findElement(by.css('#video-player-container'));
      // var videoContainer = browser.driver.findElement(by.css('#video-player-container')),
     // V_scroll= by.css('.ptv-progress.ptv-playhead-scrubber.unselectable');
      
        playPauseSelector = by.css('.ptv-controls .ptv-button.ptv-play, .ptv-controls .ptv-button.ptv-pause');
        browser.driver.actions().mouseMove(videoContainer).perform();
        //browser.driver.actions().mouseMove(V_scroll).perform();
        browser.driver.wait(function(){ 
        return browser.driver.isElementPresent(playPauseSelector);
        //return browser.driver.isElementPresent(V_scroll);
       }, 1000000);
     


 var test = browser.driver.findElement(by.css('.ptv-controls .ptv-button.ptv-play, .ptv-controls .ptv-button.ptv-pause'));//.then(function(elm){
       //elm[0].click();
       test.click();
    });
      });
       // var pause_btn = browser.driver.findElement(playPauseSelector);
       //pause_btn.click();