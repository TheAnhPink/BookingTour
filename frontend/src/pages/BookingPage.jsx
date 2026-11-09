import { useState } from 'react';
import { useParams, Link, useNavigate } from 'react-router-dom';
import { mockTourDetail } from '../data/mockTourDetail';
import '../styles/booking.css';

export default function BookingPage() {
    const { id } = useParams();
    const navigate = useNavigate();
    const tour = mockTourDetail;

    // State quản lý bước hiện tại (1: Rooming, 2: Customizations, 3: Flights, 4: Traveler Info, 5: Summary)
    const [activeStep, setActiveStep] = useState(1);
    const [bookingData, setBookingData] = useState({
        rooms: 1,
        adults: 2,
        children: 0,
        extensions: false,
        protectionPlan: false,
        flexibleAir: false,
        firstName: '',
        lastName: '',
        email: '',
        phone: '',
    });

    const handleNext = () => {
        if (activeStep < 5) setActiveStep(activeStep + 1);
    };

    const handleBack = () => {
        if (activeStep > 1) setActiveStep(activeStep - 1);
    };

    const handleChange = (e) => {
        const { name, value, type, checked } = e.target;
        setBookingData(prev => ({
            ...prev,
            [name]: type === 'checkbox' ? checked : value
        }));
    };

    const calculateTotal = () => {
        let total = bookingData.adults * tour.price + bookingData.children * tour.price * 0.75;
        if (bookingData.protectionPlan) total += 299; // Phí bảo hiểm giả định
        if (bookingData.flexibleAir) total += 500; // Phí vé linh hoạt giả định
        return total;
    };

    return (
        <div className="booking-page">
            <div className="container booking-layout">
                
                {/* CỘT TRÁI: CÁC BƯỚC ĐẶT TOUR */}
                <div className="booking-main">
                    <div className="booking-header">
                        <Link to={`/tour/${id}`} className="back-link">
                            ← Quay lại chi tiết tour
                        </Link>
                        <h1>Build Your Tour</h1>
                        <p className="subtitle">Tùy chỉnh chuyến đi của bạn</p>
                    </div>

                    {/* Thanh điều hướng các bước */}
                    <div className="booking-steps-nav">
                        {[
                            { id: 1, label: 'Rooming & Travelers' },
                            { id: 2, label: 'Tour Customizations' },
                            { id: 3, label: 'Flights & Protection' },
                            { id: 4, label: 'Traveler Information' },
                            { id: 5, label: 'Summary & Payment' }
                        ].map(step => (
                            <button
                                key={step.id}
                                className={`step-tab ${activeStep === step.id ? 'active' : ''}`}
                                onClick={() => setActiveStep(step.id)}
                            >
                                {step.id}. {step.label}
                            </button>
                        ))}
                    </div>

                    {/* NỘI DUNG TỪNG BƯỚC */}
                    <div className="booking-step-content">
                        
                        {/* BƯỚC 1: ROOMING & TRAVELERS */}
                        {activeStep === 1 && (
                            <div className="step-section">
                                <h2>Rooming & Travelers</h2>
                                <p className="step-desc">Please select your accommodation choices for all travelers going on your tour.</p>
                                
                                <div className="form-group">
                                    <label>Number of Rooms</label>
                                    <select name="rooms" value={bookingData.rooms} onChange={handleChange}>
                                        <option value={1}>1 Room</option>
                                        <option value={2}>2 Rooms</option>
                                        <option value={3}>3 Rooms</option>
                                    </select>
                                </div>

                                <div className="form-group">
                                    <label>Number of Adults</label>
                                    <input type="number" name="adults" min="1" value={bookingData.adults} onChange={handleChange} />
                                    <span className="price-hint">Giá: {tour.price.toLocaleString('vi-VN')} đ/khách</span>
                                </div>

                                <div className="form-group">
                                    <label>Number of Children (5-10)</label>
                                    <input type="number" name="children" min="0" value={bookingData.children} onChange={handleChange} />
                                    <span className="price-hint">Giá: {(tour.price * 0.75).toLocaleString('vi-VN')} đ/khách</span>
                                </div>
                            </div>
                        )}

                        {/* BƯỚC 2: TOUR CUSTOMIZATIONS */}
                        {activeStep === 2 && (
                            <div className="step-section">
                                <h2>Tour Customizations</h2>
                                <p className="step-desc">Personalize your tour with optional experiences.</p>
                                
                                <div className="custom-option">
                                    <label>
                                        <input type="checkbox" name="extensions" checked={bookingData.extensions} onChange={handleChange} />
                                        Pre and Post Extensions
                                    </label>
                                    <p>Extend your stay before or after the tour.</p>
                                </div>
                            </div>
                        )}

                        {/* BƯỚC 3: FLIGHTS & PROTECTION */}
                        {activeStep === 3 && (
                            <div className="step-section">
                                <h2>Flights & Protection</h2>
                                <p className="step-desc">Choose your airfare and protection options.</p>
                                
                                <div className="custom-option">
                                    <label>
                                        <input type="checkbox" name="flexibleAir" checked={bookingData.flexibleAir} onChange={handleChange} />
                                        Flexible Airfare
                                    </label>
                                    <p>Refundable airfare covered under Collette's Travel Protection Plan.</p>
                                </div>

                                <div className="custom-option">
                                    <label>
                                        <input type="checkbox" name="protectionPlan" checked={bookingData.protectionPlan} onChange={handleChange} />
                                        Collette's Travel Protection Plan
                                    </label>
                                    <p>Full refund for the price of the tour, right up to the day prior to departure.</p>
                                </div>
                            </div>
                        )}

                        {/* BƯỚC 4: TRAVELER INFORMATION */}
                        {activeStep === 4 && (
                            <div className="step-section">
                                <h2>Traveler Information</h2>
                                <p className="step-desc">Please enter the legal name as it appears on your government-issued ID.</p>
                                
                                <div className="form-row">
                                    <div className="form-group">
                                        <label>First Name</label>
                                        <input type="text" name="firstName" placeholder="Văn A" onChange={handleChange} />
                                    </div>
                                    <div className="form-group">
                                        <label>Last Name</label>
                                        <input type="text" name="lastName" placeholder="Nguyễn" onChange={handleChange} />
                                    </div>
                                </div>

                                <div className="form-row">
                                    <div className="form-group">
                                        <label>Email Address</label>
                                        <input type="email" name="email" placeholder="email@example.com" onChange={handleChange} />
                                    </div>
                                    <div className="form-group">
                                        <label>Phone Number</label>
                                        <input type="tel" name="phone" placeholder="0901234567" onChange={handleChange} />
                                    </div>
                                </div>
                            </div>
                        )}

                        {/* BƯỚC 5: SUMMARY & PAYMENT */}
                        {activeStep === 5 && (
                            <div className="step-section">
                                <h2>Summary & Payment</h2>
                                <p className="step-desc">Please review your tour details before inputting payment information.</p>
                                
                                <div className="summary-review">
                                    <h3>Summary Information</h3>
                                    <div className="review-row">
                                        <span>Tour:</span> <span>{tour.title}</span>
                                    </div>
                                    <div className="review-row">
                                        <span>Number of Travelers:</span> <span>{bookingData.adults} Adults, {bookingData.children} Children</span>
                                    </div>
                                    <div className="review-row">
                                        <span>Protection Plan:</span> <span>{bookingData.protectionPlan ? 'Yes' : 'No'}</span>
                                    </div>
                                    <div className="review-row total">
                                        <span>Total:</span> <strong>{calculateTotal().toLocaleString('vi-VN')} đ</strong>
                                    </div>
                                </div>

                                <div className="payment-section">
                                    <h3>Payment Information</h3>
                                    <p>Credit Card and Cardholder Information</p>
                                    {/* Form thanh toán giả lập */}
                                    <div className="form-group">
                                        <label>Card Number</label>
                                        <input type="text" placeholder="**** **** **** ****" />
                                    </div>
                                </div>
                            </div>
                        )}

                        {/* NÚT ĐIỀU HƯỚNG */}
                        <div className="step-actions">
                            {activeStep > 1 && (
                                <button className="btn btn-outline" onClick={handleBack}>Back</button>
                            )}
                            {activeStep < 5 ? (
                                <button className="btn btn-primary" onClick={handleNext}>Continue</button>
                            ) : (
                                <button className="btn btn-primary btn-pay" onClick={() => alert('Booking Confirmed!')}>
                                    Complete Booking
                                </button>
                            )}
                        </div>
                    </div>
                </div>

                {/* CỘT PHẢI: TÓM TẮT ĐƠN HÀNG */}
                <aside className="booking-sidebar">
                    <div className="summary-card">
                        <img src={tour.image} alt={tour.title} className="summary-image" />
                        <div className="summary-details">
                            <h3>{tour.title}</h3>
                            <p className="summary-meta">📍 {tour.location} | ⏱ {tour.duration}</p>
                            
                            <hr />
                            
                            <div className="price-breakdown">
                                <div className="price-row">
                                    <span>Adults x {bookingData.adults}</span>
                                    <span>{(bookingData.adults * tour.price).toLocaleString('vi-VN')} đ</span>
                                </div>
                                <div className="price-row">
                                    <span>Children x {bookingData.children}</span>
                                    <span>{(bookingData.children * tour.price * 0.75).toLocaleString('vi-VN')} đ</span>
                                </div>
                                {bookingData.protectionPlan && (
                                    <div className="price-row">
                                        <span>Protection Plan</span>
                                        <span>299.000 đ</span>
                                    </div>
                                )}
                            </div>
                            
                            <hr />
                            
                            <div className="price-total">
                                <span>Total</span>
                                <strong>{calculateTotal().toLocaleString('vi-VN')} đ</strong>
                            </div>
                        </div>
                    </div>
                </aside>
            </div>
        </div>
    );
}