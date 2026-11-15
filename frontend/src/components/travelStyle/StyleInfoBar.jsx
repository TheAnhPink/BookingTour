export default function StyleInfoBar({ groupSize, activityLevel, whatToExpect }) {
    return (
        <div className="quick-info-bar">
            <div className="container quick-info-grid">
                <div className="info-item">
                    <span className="info-label">GROUP SIZE</span>
                    <span className="info-value">{groupSize}</span>
                </div>
                <div className="info-item">
                    <span className="info-label">ACTIVITY LEVEL</span>
                    <span className="info-value">{activityLevel}</span>
                </div>
                <div className="info-item">
                    <span className="info-label">WHAT TO EXPECT</span>
                    <span className="info-value">{whatToExpect}</span>
                </div>
            </div>
        </div>
    );
}