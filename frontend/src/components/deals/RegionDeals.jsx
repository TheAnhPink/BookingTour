import { dealRegions } from '../../data/mockDeals';

export default function RegionDeals() {
    return (
        <section className="section region-deals">
            <div className="container">
                <div className="section-header">
                    <h2>Travel Deals By Region</h2>
                    <p>With over 170 tours to choose from across all 7 continents, there’s a tour — and a deal — for every type of traveler.</p>
                </div>
                <div className="region-grid">
                    {dealRegions.map((region) => (
                        <div key={region.name} className="region-card">
                            <span className="region-icon">{region.icon}</span>
                            <h4>{region.name}</h4>
                            <p>{region.count} Tours</p>
                        </div>
                    ))}
                </div>
            </div>
        </section>
    );
}