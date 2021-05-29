import "./App.css";
import { Row, Col, Input, Select, Button } from "antd";
import { MonitorOutlined, SearchOutlined } from "@ant-design/icons";
import "antd/dist/antd.css";
import { useState, useEffect } from "react";
import jobApi from "./api";
import { Link } from "react-router-dom";
import "./content.css";
import { KeyOutlined } from "@ant-design/icons";
import { tinhThanhpho, typejob } from "./static";

import TablePagination from "@material-ui/core/TablePagination";
const { Option } = Select;

const App = () => {
  const [companyName, setCompanyName] = useState("");
  const [typeJob, setTypeJob] = useState("");
  const [address, setAddress] = useState("");
  const [data, setData] = useState([] || null);
  const [params, setParams] = useState({});
  const [count, setCount] = useState(-1);
  const [page, setPage] = useState(0);
  const [rowsPerPage, setRowsPerPage] = useState(10);

  // eslint-disable-next-line react-hooks/exhaustive-deps
  useEffect(async () => {
    const params = {
      start: page === 0 ? 0 : page * rowsPerPage + 1,
      offset: rowsPerPage,
      TypeJob: typeJob,
      Address: address,
      CompanyName: companyName,
    };
    setParams(params);
  }, [page, rowsPerPage, typeJob, address, companyName]);
  const handleChangePage = (event, newPage) => {
    setPage(newPage);
  };

  const handleChangeRowsPerPage = (event) => {
    setRowsPerPage(parseInt(event.target.value, 10));
    setPage(0);
  };
  // eslint-disable-next-line react-hooks/exhaustive-deps
  useEffect(async () => {
    const params = {
      start: page === 0 ? 0 : page * rowsPerPage + 1,
      offset: rowsPerPage,
      TypeJob: typeJob,
      Address: address,
      CompanyName: companyName,
    };
    const listData = await jobApi.search(params);
    setData(listData);
  }, [page, rowsPerPage]);
  const onFinish = async () => {
    try {
      const listData = await jobApi.search(params);
      const count = await jobApi.getCount(params);
      setData(listData);
      setCount(count);
      setPage(0);
      setRowsPerPage(10);
    } catch (error) {
      alert("Error");
    }
  };
  const onChangeCompanyName = (event) => {
    setCompanyName(event.target.value);
  };
  const optionAddress = tinhThanhpho.map((value) => (
    <Option key={value} value={value}>
      {value}
    </Option>
  ));
  const typeJobs = typejob.map((value) => (
    <Option key={value} value={value}>
      {value}
    </Option>
  ));

  return (
    <div className="background">
      <div className="header">
        <Row>
          <Col span={10}>
            <Input
              type="text"
              onChange={onChangeCompanyName}
              className="styleSearch"
              placeholder="Tên công ty, tổ chức, doanh nghiệp ..."
              prefix={
                <SearchOutlined style={{ fontSize: "20px", color: "#08c" }} />
              }
            />
          </Col>
          <Col span={5}>
            <div className="styleSearch">
              <Select
                onChange={(value) => {
                  setTypeJob(value);
                }}
                size="large"
                showSearch
                style={{
                  fontSize: "13px",
                  width: "100%",
                  marginLeft: "20px",
                }}
                placeholder="Loại công việc"
                optionFilterProp="children"
                filterOption={(input, option) =>
                  option.children.toLowerCase().indexOf(input.toLowerCase()) >=
                  0
                }
                filterSort={(optionA, optionB) =>
                  optionA.children
                    .toLowerCase()
                    .localeCompare(optionB.children.toLowerCase())
                }
              >
                {typeJobs}
              </Select>
            </div>
          </Col>
          <Col span={5}>
            <div className="styleSearch">
              <Select
                onChange={(value) => {
                  setAddress(value);
                }}
                size="large"
                style={{ fontSize: "13px", width: "100%" }}
                showSearch
                placeholder="Tỉnh, Thành phố"
                optionFilterProp="children"
                filterOption={(input, option) =>
                  option.children.toLowerCase().indexOf(input.toLowerCase()) >=
                  0
                }
                filterSort={(optionA, optionB) =>
                  optionA.children
                    .toLowerCase()
                    .localeCompare(optionB.children.toLowerCase())
                }
              >
                {optionAddress}
              </Select>
            </div>
          </Col>
          <Col span={4}>
            <Button
              onClick={onFinish}
              htmlType="button"
              style={{ width: "80%" }}
              className="styleSearch"
              size="large"
              type="primary"
            >
              Tìm kiếm
            </Button>
          </Col>
        </Row>
        <Row>
          <div className="map">
            <MonitorOutlined style={{ fontSize: "20px", marginTop: "2px" }} />
            <Link className="link" to="../job_vn.html">
              Show Map
            </Link>
          </div>
        </Row>
      </div>
      <Contents data={data} count={count} />
      <div className={count < 11 ? "disable" : "enable pagination"}>
        <TablePagination
          component="div"
          count={count}
          page={page}
          onChangePage={handleChangePage}
          rowsPerPage={rowsPerPage}
          onChangeRowsPerPage={handleChangeRowsPerPage}
        />
      </div>
      <div className="footer"></div>
    </div>
  );
};

export default App;
export const Contents = ({ data, count }) => {
  const content = data.map((value) => <Item dataItem={value} />);
  return (
    <>
      <div className={count === -1 ? "enable title2" : "disable"}>
        Top 10 công việc phổ biến hiện tại
      </div>
      <div className="content">
        <div className={count === -1 ? "disable" : "enable title"}>
          <KeyOutlined />
          <span style={{ marginLeft: "5px" }}>Tìm thấy {count} kết quả</span>
        </div>
        <div className="list">{content}</div>
      </div>
    </>
  );
};

export const Item = ({ dataItem }) => {
  return (
    <div className="data" key={dataItem.id}>
      <div className="left">
        <div>
          <Link to={`/job/${dataItem.id}`}>{dataItem.job_Name}</Link>
        </div>
        <div>{dataItem.company_Name}</div>
      </div>
      <div className="right">
        <div>
          Mức lương (Nghìn/VNĐ) :
          <p>
            {dataItem.salary[0]} - {dataItem.salary[1]}
          </p>
        </div>
        <div>Địa điểm: {dataItem.address}</div>
        <div>Hạn nộp: {dataItem.deadline}</div>
        <div>
          Vị trí cần tuyển dụng :
          {dataItem.level ? dataItem.level : "Mọi vị trí"}
        </div>
      </div>
    </div>
  );
};
