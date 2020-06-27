package com.abc.accommodation.init;

import com.abc.accommodation.model.Post;
import com.abc.accommodation.model.User;
import com.abc.accommodation.repository.PostRepository;
import com.abc.accommodation.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataLoader implements CommandLineRunner {
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        User user;
        user = new User("abc",passwordEncoder.encode("123456"),"0962344567");
        user = userRepository.save(user);

        Post post;
        post= new Post("Cho thuê nhà","Thủ Đức, TP HCM",1000000.0,"0976282346","https://news.mogi.vn/wp-content/uploads/2019/09/nha-nguyen-can-cho-thue-3.jpg",user);
        postRepository.save(post);
        post = new Post("Cho thuê nhà giá rẻ TPHCM","Tân Bình, TP Hồ Chí Minh",750000.0,"0346364685","https://file4.batdongsan.com.vn/2016/03/01/b9sp0zUm/20160301092321-59dd.jpg",user);
        postRepository.save(post);
        post = new Post("Thuê nhà giá ưu đãi cho sinh viên","Linh Xuân, Bình Dương",500000.0,"0993465321","https://cms.luatvietnam.vn/uploaded/Images/Original/2018/12/06/nha-tro_0612134255.jpg",user);
        postRepository.save(post);
        post = new Post("Cho thuê nhà mặt tiền","Quận 12,TP Hồ Chí Minh",1500000.0,"0993468321","https://amp.thitruong.today/uploads/files/2019/12/28/C-ch-ng-tin-cho-thu-nh-hi-u-qu-2.jpg",user);
        postRepository.save(post);
        post = new Post("Thuê nhà giá rẻ","Linh Trung,Bình Dương",750000.0,"0983465321","https://amp.thitruong.today/uploads/files/2019/12/28/C-ch-ng-tin-cho-thu-nh-hi-u-qu-2.jpg",user);

        user = new User("phong",passwordEncoder.encode("Phong789"),"0965877543");
        user = userRepository.save(user);

        postRepository.save(post);
        post = new Post("Cho thuê nhà nguyên căn","Quận 5",5000000.0,"0993476321","https://img.vietnamfinance.vn/webp-jpg/700x0/upload/news/xuanhai/2018/10/2/cho-thue-nha-qua-airbnb-vnf.webp",user);
        postRepository.save(post);
        post = new Post("Thuê nhà giá ưu đãi cho sinh viên","Quận 7, TPHCM",600000.0,"0995465321","https://tgslaw.vn/wp-content/uploads/2020/01/cho-thue-nha-tro-co-phai-dang-ky-kinh-doanh-khong.jpg",user);
        postRepository.save(post);
        post = new Post("Thuê nhà giá siêu ưu đãi","Quận 11, TPHCM",800000.0,"0993468321","https://luattrinam.vn/uploads/img/tu-van-hop-dong/Dang%20ky%20kinh%20doanh%20cho%20thue%20nha%20tro.jpg",user);
        postRepository.save(post);


        user = new User("Hieu",passwordEncoder.encode("hieu123"),"0965876543");
        user = userRepository.save(user);

        post = new Post("Cho thuê nhà","Quận 12",6000000.0,"09934876321","https://cdn.chotot.com/WK-HaDq2E9D6S9mTvcX-R44d2UMwT_HKiQjc7Z5nW1A/preset:listing/plain/28188309c0a910cdf786e9b61e420d69-2670701303606045248.jpg",user);
        postRepository.save(post);
        post = new Post("Thuê nhà giá ưu đãi","Tân Bình, TP HCM",100000.0,"0997655321","https://img.tinbatdongsan.com/crop/480x282/2020/06/22/20200622182844-4e2b.jpg",user);
        postRepository.save(post);
        post = new Post("Cho thuê nhà nguyên căn","Quận Tây Hồ, Hà Nội",3800000.0,"0993468321","https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQ3mCAQ9w3D9BWkzBx_Cq9o8OOUVcpY3myROA&usqp=CAU",user);
        postRepository.save(post);
        post = new Post("Cho thuê nhà giá ưu đãi","Quận Hoàn Kiếm",3500000.0,"0997625321","https://phoxanh.vn/server/php/files/2%20(36).png",user);
        postRepository.save(post);

        user = new User("Son",passwordEncoder.encode("Son123"),"0965436543");
        user = userRepository.save(user);
        post = new Post("Cho thuê nhà quận 6","Quận 6, TPHCM",3500000.0,"0993325321","https://image.sggp.org.vn/w580/Uploaded/2020/dureidrkxq/2019_02_24/x8e_ekrf.jpg",user);
        postRepository.save(post);
        post = new Post("Cho thuê nhà, ưu đãi với sinh viên","Quận 9, TPHCM",520000.0,"0965465321","https://tinhaynhadat.com/media/14572/20180929225813-8ae7.jpeg",user);
        postRepository.save(post);
        post = new Post("Cho thuê nhà","Quận 9, TPHCM",520000.0,"0998465321","https://i2.wp.com/nhatrangrich.vn/wp-content/uploads/2018/12/cho-thue-nha-nha-trang.jpg",user);
        postRepository.save(post);
    }
}
