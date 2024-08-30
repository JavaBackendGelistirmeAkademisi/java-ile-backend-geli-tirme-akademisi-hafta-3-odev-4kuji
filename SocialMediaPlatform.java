import javax.xml.stream.events.Comment;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.TreeSet;

public class SocialMediaPlatform {
    public static void main(String[] args){
    }

    class User{


        public String name;
        private LinkedHashMap<Integer, Post> posts; //Kullanıcının gönderileri
        private HashSet<User> following; //Takip edilen kullanıcılar
        private TreeSet<Post> favorites; //Beğenilen Gönderiler
        private static int postCounter = 0; //Gönderi Sayacı



        public User(String name){
            this.name = name;
            this.posts = new LinkedHashMap<Integer, Post>();
            this.following = new HashSet<>();
            this.favorites = new TreeSet<Post>();
        }

        public String getName() {
            return name;
        }

        class Post {
            String content;
            Integer postCounter;
            Integer Id;
            Post(String content, Integer postCounter, Integer Id) {
                this.content = content;
                this.postCounter = postCounter;
                this.Id = Id;
            }
            

            public Integer getPostCounter() {
                Integer postCounter = 0;
                return postCounter;
            }

            public Integer getId() {
                return Id;
            }
        }
        public void follow (User user){
            following.add(user);
            System.out.println(name + ", " + user.getName() + "kullanıcısını takip ediyor");

        }

        public void createPost (String content){
            
            Post newPost = new Post(content, postCounter++, Id);
            posts.put(newPost.getId(), newPost);
            System.out.println(name + "yeni bir gönderi yayınladı:" + content);
        }

        public void addCommentToPost (User user, int postId, String comment){
            Post post = user.getPost(postId);
            if (post != null){
                post.addComment(new Comment(this, comment));
                System.out.println(name + ", " + user.getName() + "'in gönderisine yorum yaptı." + comment);
            }

        }

        public void addToPostFavorites(User user, int postId){
            Post post = user.getPost(postId);
            if (post != null){
                favorites.add(post);
                System.out.println(name + ", " + user.getName() + "'in gönderisini beğendi"+ post.getContent());
            }

        }

        public void showFeed(){
            System.out.println("\n" + name + "'in  Ana Sayfası");
            for (User user : following){
                user.showPosts();
            }


        }
    }

}