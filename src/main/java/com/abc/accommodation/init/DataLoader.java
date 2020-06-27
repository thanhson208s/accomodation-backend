package com.abc.accommodation.init;

import com.abc.accommodation.model.Post;
import com.abc.accommodation.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataLoader implements CommandLineRunner {
    @Autowired
    PostRepository postRepository;


    @Override
    public void run(String... args) throws Exception {
        Post post;
        post= new Post("Cho thuê nhà","Thủ Đức, TP HCM",1000000.0,"0976282346","https://news.mogi.vn/wp-content/uploads/2019/09/nha-nguyen-can-cho-thue-3.jpg");
        postRepository.save(post);
        post = new Post("Cho thuê nhà giá rẻ TPHCM","Tân Bình, TP Hồ Chí Minh",750000.0,"0346364685","https://file4.batdongsan.com.vn/2016/03/01/b9sp0zUm/20160301092321-59dd.jpg");
        postRepository.save(post);
        post = new Post("Thuê nhà giá ưu đãi cho sinh viên","Linh Xuân, Bình Dương",500000.0,"0993465321","https://cms.luatvietnam.vn/uploaded/Images/Original/2018/12/06/nha-tro_0612134255.jpg");
        postRepository.save(post);
        post = new Post("Cho thuê nhà mặt tiền","Quận 12,TP Hồ Chí Minh",1500000.0,"0993468321","https://amp.thitruong.today/uploads/files/2019/12/28/C-ch-ng-tin-cho-thu-nh-hi-u-qu-2.jpg");
        postRepository.save(post);
        post = new Post("Thuê nhà giá rẻ","Linh Trung,Bình Dương",750000.0,"0983465321","https://amp.thitruong.today/uploads/files/2019/12/28/C-ch-ng-tin-cho-thu-nh-hi-u-qu-2.jpg");
        postRepository.save(post);
        post = new Post("Cho thuê nhà nguyên căn","Quận",5000000.0,"0993476321","https://img.vietnamfinance.vn/webp-jpg/700x0/upload/news/xuanhai/2018/10/2/cho-thue-nha-qua-airbnb-vnf.webp");
        postRepository.save(post);
        post = new Post("Thuê nhà giá ưu đãi cho sinh viên","Quận 7, TPHCM",600000.0,"0995465321","https://tgslaw.vn/wp-content/uploads/2020/01/cho-thue-nha-tro-co-phai-dang-ky-kinh-doanh-khong.jpg");
        postRepository.save(post);
        post = new Post("Thuê nhà giá siêu ưu đãi","Quận 11, TPHCM",800000.0,"0993468321","https://luattrinam.vn/uploads/img/tu-van-hop-dong/Dang%20ky%20kinh%20doanh%20cho%20thue%20nha%20tro.jpg");
        postRepository.save(post);
        post = new Post("Cho thuê nhà quận 6","Quận 6, TPHCM",3500000.0,"0993325321","https://image.sggp.org.vn/w580/Uploaded/2020/dureidrkxq/2019_02_24/x8e_ekrf.jpg");
        postRepository.save(post);
        post = new Post("Cho thuê nhà, ưu đãi với sinh viên","Quận 9, TPHCM",520000.0,"0965465321","https://tinhaynhadat.com/media/14572/20180929225813-8ae7.jpeg");
        postRepository.save(post);

    }
}
