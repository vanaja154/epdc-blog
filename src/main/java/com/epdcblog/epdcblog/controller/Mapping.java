package com.epdcblog.epdcblog.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.epdcblog.epdcblog.entity.News;
import com.epdcblog.epdcblog.service.NewsService;

@Controller
public class Mapping {

    public static final String baseUrl = "http://admin.epdcindia.com/uploads/";
    // public static final String baseUrl = "http://192.168.1.127:18012/uploads/";


    @Autowired
    private NewsService newsService;

    @GetMapping("/")
    public String home(Model model)
    {
        // Fetch all news items under the "Blog" category
    List<News> blogNews = newsService.getNewsByCategory("Blog");
    
    // Construct full image URLs
    blogNews.forEach(this::constructImageUrls);
    
    // Add data to the model
    model.addAttribute("newsList", blogNews);
    model.addAttribute("category", "Blog"); // Explicitly set category
    
        return "blog";
    }
    
    @GetMapping("/detail/{id}")
    public String showDetailPage(@PathVariable String id,
                                 @RequestParam String category,
                                 @RequestParam(required = false) String section,
                                 Model model) {
        // Fetch all news items under the specified category
        List<News> newsList = newsService.getNewsByCategory(category);
        if (newsList.isEmpty()) {
            throw new RuntimeException("No news found for category: " + category);
        }
    
        // Construct full image URLs for all news items
        newsList.forEach(this::constructImageUrls);
    
        // Add the news list to the model (optional, if needed for rendering)
        model.addAttribute("newsList", newsList);
    
        // Default values
        String image = "";
        String title = "";
        String text = "";
    
        // Fetch the latest news for the specified category
        News news = newsService.getLatestNewsByCategory(category);
        if (news == null) {
            throw new RuntimeException("No news found for category: " + category);
        }
    
        // Construct full URLs for images in the specific News object
        constructImageUrls(news);
    
        if (section != null) {
            switch (section) {
                case "sidebar1":
                    image = news.getSidebar1Image();
                    title = news.getSidebar1Title();
                    text = news.getSidebar1Text();
                    break;
                case "sidebar2":
                    image = news.getSidebar2Image();
                    title = news.getSidebar2Title();
                    text = news.getSidebar2Text();
                    break;
                case "sidebar3":
                    image = news.getSidebar3Image();
                    title = news.getSidebar3Title();
                    text = news.getSidebar3Text();
                    break;
                case "sidebar4":
                    image = news.getSidebar4Image();
                    title = news.getSidebar4Title();
                    text = news.getSidebar4Text();
                    break;
                case "sidebar5":
                    image = news.getSidebar5Image();
                    title = news.getSidebar5Title();
                    text = news.getSidebar5Text();
                    break;
                case "sidebar6":
                    image = news.getSidebar6Image();
                    title = news.getSidebar6Title();
                    text = news.getSidebar6Text();
                    break;
                case "sidebar7":
                    image = news.getSidebar7Image();
                    title = news.getSidebar7Title();
                    text = news.getSidebar7Text();
                    break;
                case "sidebar8":
                    image = news.getSidebar8Image();
                    title = news.getSidebar8Title();
                    text = news.getSidebar8Text();
                    break;
                case "sidebar9":
                    image = news.getSidebar9Image();
                    title = news.getSidebar9Title();
                    text = news.getSidebar9Text();
                    break;
                case "sidebar10":
                    image = news.getSidebar10Image();
                    title = news.getSidebar10Title();
                    text = news.getSidebar10Text();
                    break;
                    case "sidebar11":
                    image = news.getSidebar11Image();
                    title = news.getSidebar11Title();
                    text = news.getSidebar11Text();
                    break;
                case "sidebar12":
                    image = news.getSidebar12Image();
                    title = news.getSidebar12Title();
                    text = news.getSidebar12Text();
                    break;
                case "sidebar13":
                    image = news.getSidebar13Image();
                    title = news.getSidebar13Title();
                    text = news.getSidebar13Text();
                    break;
                case "sidebar14":
                    image = news.getSidebar14Image();
                    title = news.getSidebar14Title();
                    text = news.getSidebar14Text();
                    break;
                case "sidebar15":
                    image = news.getSidebar15Image();
                    title = news.getSidebar15Title();
                    text = news.getSidebar15Text();
                    break;
                case "sidebar16":
                    image = news.getSidebar16Image();
                    title = news.getSidebar16Title();
                    text = news.getSidebar16Text();
                    break;
                case "sidebar17":
                    image = news.getSidebar17Image();
                    title = news.getSidebar17Title();
                    text = news.getSidebar17Text();
                    break;
                case "sidebar18":
                    image = news.getSidebar18Image();
                    title = news.getSidebar18Title();
                    text = news.getSidebar18Text();
                    break;
                case "sidebar19":
                    image = news.getSidebar19Image();
                    title = news.getSidebar19Title();
                    text = news.getSidebar19Text();
                    break;
                case "sidebar20":
                    image = news.getSidebar20Image();
                    title = news.getSidebar20Title();
                    text = news.getSidebar20Text();
                    break;
                

                case "right1":
                    image = news.getRightImage1();
                    break;
                case "right2":
                    image = news.getRightImage2();
                    break;

                case "item1":
                    image = news.getImage1();
                    title = news.getTitle1();
                    text = news.getText1();
                    break;
                case "item2":
                    image = news.getImage2();
                    title = news.getTitle2();
                    text = news.getText2();
                    break;
                case "item3":
                    image = news.getImage3();
                    title = news.getTitle3();
                    text = news.getText3();
                    break;
                case "item4":
                    image = news.getImage4();
                    title = news.getTitle4();
                    text = news.getText4();
                    break;
                case "item5":
                    image = news.getImage5();
                    title = news.getTitle5();
                    text = news.getText5();
                    break;
                case "item6":
                    image = news.getImage6();
                    title = news.getTitle6();
                    text = news.getText6();
                    break;
                case "item7":
                    image = news.getImage7();
                    title = news.getTitle7();
                    text = news.getText7();
                    break;
                case "item8":
                    image = news.getImage8();
                    title = news.getTitle8();
                    text = news.getText8();
                    break;
                case "item9":
                    image = news.getImage9();
                    title = news.getTitle9();
                    text = news.getText9();
                    break;
                case "item10":
                    image = news.getImage10();
                    title = news.getTitle10();
                    text = news.getText10();
                    break;
                default:
                    throw new RuntimeException("Invalid section parameter: " + section);
            }
        } else {
            throw new RuntimeException("Invalid request: section parameter is required");
        }
        // Add attributes to the model
        model.addAttribute("mainImage", image);
        model.addAttribute("title", title);
        model.addAttribute("mainText", text);
        model.addAttribute("category", category);
    
        return "details-news";
    } 
    @GetMapping("/details-news")
    public String details() {
      return "details-news";
    }
 

    // Helper method to construct full URLs for images
    private String constructImageUrl(String imagePath) {
        if (imagePath == null || imagePath.isEmpty()) {
            return ""; // Return an empty string or a default image URL
        }
        return baseUrl + imagePath.replace("\\", "/");
    }

    // Helper method to construct full URLs for News images
    private void constructImageUrls(News news) {
        news.setSidebar1Image(constructImageUrl(news.getSidebar1Image()));
        news.setSidebar2Image(constructImageUrl(news.getSidebar2Image()));
        news.setSidebar3Image(constructImageUrl(news.getSidebar3Image()));
        news.setSidebar4Image(constructImageUrl(news.getSidebar4Image()));
        news.setSidebar5Image(constructImageUrl(news.getSidebar5Image()));
        news.setSidebar6Image(constructImageUrl(news.getSidebar6Image()));
        news.setSidebar7Image(constructImageUrl(news.getSidebar7Image()));
        news.setSidebar8Image(constructImageUrl(news.getSidebar8Image()));
        news.setSidebar9Image(constructImageUrl(news.getSidebar9Image()));
        news.setSidebar10Image(constructImageUrl(news.getSidebar10Image()));

        news.setSidebar11Image(constructImageUrl(news.getSidebar11Image()));
        news.setSidebar12Image(constructImageUrl(news.getSidebar12Image()));
        news.setSidebar13Image(constructImageUrl(news.getSidebar13Image()));
        news.setSidebar14Image(constructImageUrl(news.getSidebar14Image()));
        news.setSidebar15Image(constructImageUrl(news.getSidebar15Image()));
        news.setSidebar16Image(constructImageUrl(news.getSidebar16Image()));
        news.setSidebar17Image(constructImageUrl(news.getSidebar17Image()));
        news.setSidebar18Image(constructImageUrl(news.getSidebar18Image()));
        news.setSidebar19Image(constructImageUrl(news.getSidebar19Image()));
        news.setSidebar20Image(constructImageUrl(news.getSidebar20Image()));

        news.setRightImage1(constructImageUrl(news.getRightImage1()));
        news.setRightImage2(constructImageUrl(news.getRightImage2()));

        news.setImage1(constructImageUrl(news.getImage1()));
        news.setImage2(constructImageUrl(news.getImage2()));
        news.setImage3(constructImageUrl(news.getImage3()));
        news.setImage4(constructImageUrl(news.getImage4()));
        news.setImage5(constructImageUrl(news.getImage5()));
        news.setImage6(constructImageUrl(news.getImage6()));
        news.setImage7(constructImageUrl(news.getImage7()));
        news.setImage8(constructImageUrl(news.getImage8()));
        news.setImage9(constructImageUrl(news.getImage9()));
        news.setImage10(constructImageUrl(news.getImage10()));
    }
}