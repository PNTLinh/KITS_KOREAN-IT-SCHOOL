## Problem
Trong tương lai gần, cửa hàng văn phòng phẩm A và sàn thương mại điện tử B có
thể sẽ tiến tới một thương vụ sáp nhập nhằm cạnh tranh với các nền tảng thương mại
điện tử khác. Sự hợp nhất này sẽ tạo ra một công ty mới mang tên AB Company.
Nhằm phát triển hoạt động kinh doanh trực tuyến, AB Company quyết định xây
dựng một hệ thống mới cho dự án AIMS (An Internet Media Store), một cửa hàng
trực tuyến chuyên cung cấp các sản phẩm truyền thông số, bao gồm DVD, CD và
sách. Hệ thống được kỳ vọng sẽ cải thiện trải nghiệm mua sắm cho khách hàng, đồng
thời tối ưu hóa quy trình quản lý và vận hành của cửa hàng.
Hệ thống AIMS cho phép khách hàng duyệt danh sách sản phẩm trong cửa hàng
theo thứ tự ngày thêm, từ mới nhất đến cũ nhất, giúp khách hàng nhanh chóng cập
nhật các sản phẩm mới nhất. Khi tìm kiếm sản phẩm, khách hàng có thể sử dụng ba
lựa chọn linh hoạt: tìm theo tiêu đề bằng cách nhập các từ khóa, tìm theo danh mục
sản phẩm hoặc tìm theo mức giá, có thể nhập giá tối đa hoặc khoảng giá cụ thể. Kết
quả tìm kiếm hiển thị tất cả thông tin liên quan đến sản phẩm và cho phép khách
hàng xem chi tiết hoặc thêm sản phẩm vào giỏ hàng, từ đó giúp khách hàng ra quyết
định mua hàng nhanh chóng và thuận tiện hơn.
Khách hàng có thể xem và quản lý giỏ hàng của mình, bao gồm hiển thị thông tin
chi tiết của từng sản phẩm và tổng chi phí dự kiến. Hệ thống còn cho phép nghe thử
CD hoặc xem demo DVD trước khi đặt hàng, giúp khách hàng đánh giá chất lượng
sản phẩm trước khi quyết định mua. Nếu độ dài của DVD, CD hoặc track ≤ 0, hệ
thống sẽ thông báo để khách hàng không lãng phí thời gian với các sản phẩm không
thể phát. Sản phẩm trong giỏ hàng có thể được sắp xếp theo tiêu đề hoặc theo giá,
đồng thời khách hàng có thể cập nhật số lượng, xóa sản phẩm, lọc sản phẩm theo ID
hoặc tiêu đề, tạo sự linh hoạt trong quản lý giỏ hàng. Hệ thống còn có tính năng
khuyến mãi thực tế bằng cách tặng ngẫu nhiên một sản phẩm miễn phí, khuyến khích
khách hàng mua nhiều hơn.
Khi khách hàng quyết định đặt hàng, hệ thống sẽ yêu cầu nhập thông tin giao hàng
và hướng dẫn cụ thể, đồng thời tự động tính phí giao hàng dựa trên tổng khối lượng
và địa điểm giao. Hóa đơn hiển thị đầy đủ danh sách sản phẩm, tổng chi phí trước
và sau VAT, cùng phí giao hàng, giúp khách hàng dễ dàng kiểm tra lại trước khi
thanh toán. Thanh toán được thực hiện bằng thẻ tín dụng, kết nối trực tiếp với ngân
hàng để kiểm tra thẻ và hoàn tất giao dịch một cách an toàn. Sau khi giao dịch thành
công, hệ thống hiển thị chi tiết giao dịch, bao gồm số giao dịch, tên chủ thẻ, số tiền
và ngày giao dịch, đồng thời gửi email xác nhận đơn hàng và giao dịch đến khách
hàng.
Đối với quản lý cửa hàng, người quản lý cần đăng nhập để truy cập chế độ quản lý.
Trong chế độ này, quản lý có thể xem và xử lý các đơn hàng đang chờ, duyệt hoặc
từ chối từng đơn, đảm bảo việc vận hành cửa hàng diễn ra suôn sẻ. Quản lý còn có

thể thêm mới hoặc xóa các sản phẩm DVD, CD và sách, nhập đầy đủ thông tin cần
thiết như ID, tiêu đề, danh mục, tác giả/đạo diễn/nghệ sĩ, độ dài và giá, giúp duy trì
kho sản phẩm luôn cập nhật và đáp ứng nhu cầu thị trường.
Thông tin chi tiết của sản phẩm được hiển thị tùy theo loại sản phẩm. Sách bao gồm
ID, tiêu đề, danh mục, danh sách tác giả, độ dài nội dung và giá; CD bao gồm ID,
tiêu đề, danh mục, nghệ sĩ, đạo diễn, danh sách track với từng track có tiêu đề và độ
dài, tổng độ dài CD là tổng độ dài các track; DVD bao gồm ID, tiêu đề, danh mục,
đạo diễn, độ dài và giá. Khi phát CD hoặc DVD, hệ thống hiển thị tiêu đề và độ dài
sản phẩm, nếu độ dài ≤ 0, hệ thống sẽ thông báo không thể phát, tránh gây thất vọng
cho khách hàng.
Như vậy, hệ thống AIMS được thiết kế với mục tiêu vừa tạo ra trải nghiệm mua sắm
trực tuyến thuận tiện, vừa hỗ trợ quản lý vận hành thực tế của cửa hàng. Khách hàng
có thể dễ dàng tìm kiếm, lựa chọn và thanh toán sản phẩm, đồng thời quản lý được
cung cấp đầy đủ công cụ để quản lý đơn hàng và sản phẩm, giúp AB Company vận
hành hiệu quả trong môi trường thương mại điện tử cạnh tranh.

## Structure
Client (browser/app) → Controller (REST API, nhận request) → Service (business logic, transaction) → Repository (truy vấn DB) → Entity / Database
Ngoài ra có: DTO (dùng để trao đổi dữ liệu), Security (xác thực/ủy quyền, JWT), AimsApplication là entrypoint.

