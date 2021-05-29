import "./App.css";
import { useParams, Link } from "react-router-dom";
import {
  DashboardOutlined,
  DollarOutlined,
  EnvironmentOutlined,
  IdcardOutlined,
  UserDeleteOutlined,
  UserOutlined,
} from "@ant-design/icons";
import { useState, useEffect } from "react";
import jobApi from "./api";
const Detail = () => {
  const { id } = useParams();
  const [dataInfo1, setDataInfo1] = useState([]);

  useEffect(() => {
    const fetchJobInfo = async () => {
      if (id) {
        try {
          const jobInfo = await jobApi.getJob(id);
          setDataInfo1(jobInfo);
        } catch (error) {
          alert("error");
        }
      }
    };
    fetchJobInfo();
  }, [id]);
  const content = dataInfo1.map((value) => (
    <div key={value.id} className="item">
      <div>
        <p className="nameJob">{value.job_Name}</p>
        <p className="companyJob"> {value.company_Name}</p>
      </div>
      <div className="jobdetail">
        <div>
          <p>
            <DollarOutlined />
            <span className="icons">Mức lương (Nghìn/VND)</span>
          </p>
          <p>
            {value.salary[0]} - {value.salary[1]}
          </p>
        </div>
        <div>
          <p>
            <DashboardOutlined />
            <span className="icons">Hạn nộp hồ sơ</span>
          </p>
          <p> {value.deadline}</p>
        </div>
        <div>
          <p>
            <EnvironmentOutlined />
            <span className="icons">Địa điểm</span>
          </p>
          <p style={{ color: "blue", fontWeight: "500" }}>{value.address}</p>
        </div>
        <div>
          <p>
            <IdcardOutlined />
            <span className="icons">Ngành nghề</span>
          </p>
          <p style={{ color: "blue", fontWeight: "500" }}>
            {value.type_Job.map((value, index) => (
              <p key={index}>{value}</p>
            ))}
          </p>
        </div>
        <div>
          <p>
            <UserOutlined />
            <span className="icons"> Cấp bậc</span>
          </p>
          <p> {value.level ? value.level : "Đang cập nhật"}</p>
        </div>
        <div>
          <p>
            <UserDeleteOutlined />
            <span className="icons">Chức vụ</span>
          </p>
          <p> {value.form ? value.form : "Đang cập nhật"}</p>
        </div>
      </div>
      <div className="des">
        <p className="tt">Mô tả công việc</p>
        <p className="rer">
          {value.describe.map((value, index) => (
            <p key={index}>{value}</p>
          ))}
        </p>
      </div>
      <div className="des">
        <p className="tt">Yêu cầu công viêc</p>
        <p className="rer">
          {value.requirement.map((value, index) => (
            <p key={index}>{value}</p>
          ))}
        </p>
      </div>
    </div>
  ));
  return <div>{content}</div>;
};
export default Detail;
