import './../../styles/home.css';

const placeholderTours = [
    { id: 1, title: 'Treasures of South Africa', duration: '12 Days', price: 'From $3,499' },
    { id: 2, title: 'Italian Vistas', duration: '10 Days', price: 'From $2,899' },
    { id: 3, title: 'Northern Lights of Iceland', duration: '8 Days', price: 'From $3,199' },
];

export default function FeaturedTours() {
    return (
        <section className="section featured">
            <div className="container">
                <div className="section-header">
                    <div>
                        <h2>Featured Tours</h2>
                        <p>Inspire your next journey with hand-picked tours travelers love.</p>
                    </div>
                    <a href="#" className="see-all">View All Tours →</a>
                </div>

                <div className="tour-grid">
                    {placeholderTours.map((tour) => (
                        <div key={tour.id} className="tour-card">
                            <div className="tour-image">
                                <img
                                    src={`https://picsum.photos/seed/tour${tour.id}/600/400`}
                                    alt={tour.title}
                                />
                                <span className="tour-duration">{tour.duration}</span>
                            </div>
                            <div className="tour-body">
                                <h3>{tour.title}</h3>
                                <p className="tour-price">{tour.price}</p>
                                <button className="btn btn-outline btn-sm">View Tour</button>
                            </div>
                        </div>
                    ))}
                </div>
            </div>
        </section>
    );
}