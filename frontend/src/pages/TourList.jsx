import { useState } from 'react';
import { mockTours } from '../data/mockTours';
import TourCard from '../components/tour/TourCard';
import '../styles/tour.css';

export default function TourList() {
    const [priceRange, setPriceRange] = useState('all');

    return (
        <div className="tour-page-wrapper">
            {/* Banner tiêu đề nhỏ */}
            <div className="tour-page-banner">
                <div className="container">
                    <h1>Find Your Tour</h1>
                    <p>Explore our expertly crafted tours around the world.</p>
                </div>
            </div>

            <div className="container tour-layout">
                {/* CỘT TRÁI: BỘ LỌC (FILTERS) */}
                <aside className="tour-filters">
                    <h3>Filter By</h3>
                    
                    <div className="filter-group">
                        <h4>Destination</h4>
                        <label><input type="checkbox" /> Europe</label>
                        <label><input type="checkbox" /> North America</label>
                        <label><input type="checkbox" /> Asia</label>
                        <label><input type="checkbox" /> Africa</label>
                    </div>

                    <div className="filter-group">
                        <h4>Price</h4>
                        <label><input type="radio" name="price" onChange={() => setPriceRange('all')} defaultChecked /> All Prices</label>
                        <label><input type="radio" name="price" onChange={() => setPriceRange('under3000')} /> Under $3,000</label>
                        <label><input type="radio" name="price" onChange={() => setPriceRange('over3000')} /> $3,000 & Above</label>
                    </div>

                    <div className="filter-group">
                        <h4>Duration</h4>
                        <label><input type="checkbox" /> Under 7 Days</label>
                        <label><input type="checkbox" /> 7 - 10 Days</label>
                        <label><input type="checkbox" /> Over 10 Days</label>
                    </div>
                </aside>

                {/* CỘT PHẢI: DANH SÁCH TOUR */}
                <div className="tour-results">
                    {/* Thanh công cụ (Sort & Count) */}
                    <div className="tour-toolbar">
                        <span>Showing <strong>{mockTours.length}</strong> tours</span>
                        <div className="sort-box">
                            <label>Sort by: </label>
                            <select>
                                <option>Recommended</option>
                                <option>Price (Low to High)</option>
                                <option>Price (High to Low)</option>
                            </select>
                        </div>
                    </div>

                    {/* Danh sách thẻ Tour */}
                    <div className="tour-list-vertical">
                        {mockTours.map(tour => (
                            <TourCard key={tour.id} tour={tour} />
                        ))}
                    </div>

                    {/* Phân trang (Pagination) */}
                    <div className="pagination">
                        <button className="page-btn active">1</button>
                        <button className="page-btn">2</button>
                        <button className="page-btn">3</button>
                        <button className="page-btn">Next ›</button>
                    </div>
                </div>
            </div>
        </div>
    );
}