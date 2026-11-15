import useFetch from '../../hooks/useFetch';
import { homeApi } from '../../api/home/homeApi';
import './../../styles/home.css';

export default function HeroSection() {
    const { data } = useFetch(homeApi.getBanner);

    // Link ảnh mặc định nếu Backend chưa có
    const defaultImage = 'https://images.unsplash.com/photo-1549421255-70663d14bc16?q=80&w=2000';
    const bgImage = data?.imageUrl || defaultImage;

    return (
        <section 
            className="hero-section" 
            style={{ backgroundImage: `url(${bgImage})` }}
        >
            <div className="hero-overlay"></div>

            <div className="hero-content">
                <h1 className="hero-title">
                    By Travelers. For Travelers.<sup>®</sup>
                </h1>
                
                {/* Tiêu đề phụ */}
                <p className="hero-subtitle">
                    Expertly crafted guided tours for the modern traveler
                </p>

                {/* Thanh Tìm Kiếm */}
                <div className="hero-search-container">
                    <div className="hero-search-bar">
                        <div className="search-icon-circle">
                            <svg width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="#005a8c" strokeWidth="3" strokeLinecap="round" strokeLinejoin="round">
                                <circle cx="11" cy="11" r="8"></circle>
                                <line x1="21" y1="21" x2="16.65" y2="16.65"></line>
                            </svg>
                        </div>
                        <input 
                            type="text" 
                            className="hero-search-input"
                            placeholder="Where do you want to go?" 
                        />
                    </div>
                </div>
            </div>
        </section>
    );
}