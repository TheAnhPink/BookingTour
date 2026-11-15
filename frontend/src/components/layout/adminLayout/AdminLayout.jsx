import { Outlet, Link, useNavigate } from 'react-router-dom';
import './adminLayout.css';

export default function AdminLayout() {
    const navigate = useNavigate();

    const handleLogout = () => {
        // Tạm thời chỉ chuyển hướng về trang chủ để test
        navigate('/');
    };

    return (
        <div className="admin-layout">
            {/* Sidebar */}
            <aside className="admin-sidebar">
                <h2 style={{ padding: '20px', color: '#fff', borderBottom: '1px solid #334155' }}>
                    ⚙️ Admin Panel
                </h2>
                <nav className="sidebar-nav">
                    <Link to="/admin" className="nav-item">📊 Tổng quan</Link>
                    <Link to="/admin/tours" className="nav-item">🏖 Quản lý Tour</Link>
                    <Link to="/admin/orders" className="nav-item">📦 Quản lý Đơn hàng</Link>
                </nav>
                <div style={{ padding: '20px', marginTop: 'auto' }}>
                    <Link to="/" style={{ color: '#94a3b8', textDecoration: 'none' }}>⬅️ Về trang chủ</Link>
                </div>
            </aside>

            {/* Nội dung chính */}
            <div className="admin-main">
                <header className="admin-topbar">
                    <h3>Hệ thống Quản trị Tour</h3>
                    <div style={{ display: 'flex', alignItems: 'center', gap: '15px' }}>
                        <span style={{ fontWeight: 'bold' }}>👤 Admin (Test)</span>
                        <button onClick={handleLogout} style={{ padding: '5px 10px', cursor: 'pointer' }}>Thoát</button>
                    </div>
                </header>
                <div className="admin-content">
                    <Outlet />
                </div>
            </div>
        </div>
    );
}