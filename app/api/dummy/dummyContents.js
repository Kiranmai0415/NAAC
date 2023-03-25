import avatarApi from '../images/avatars';
import currentUser from '../../containers/Pages/Users/services/auth.service';
// alert('current user ==>' + currentUser.getCurrentUser().email);
let userName = 'Dummy';
let role = 'Faculty';
const userRoleArray = [
  { key: 'ROLE_FACULTY', value: 'Faculty' },
  { key: 'ROLE_DEAN', value: 'Dean' },
  { key: 'ROLE_PRINCIPAL', value: 'Principal' },
];

if (currentUser.getCurrentUser()) {
  userName = currentUser.getCurrentUser().email;
  // eslint-disable-next-line prefer-destructuring
  role = currentUser.getCurrentUser().roles[0];
}
console.log('role from the database is ==>' + role);
// eslint-disable-next-line array-callback-return
userRoleArray.map(({ key, value }) => {
  if (key === role) {
    role = value;
  }
});
console.log('what is the role of the user ==>' + avatarApi[8]);
const dummyContents = {
  user: {
    name: userName,
    title: role,
    avatar: avatarApi[3],
    status: 'online'
  },
  text: {
    title: 'Lorem ipsum',
    subtitle: 'Ut a lorem eu odio cursus laoreet.',
    sentences: 'Donec lacus sem, scelerisque sed ligula nec, iaculis porttitor mauris.',
    paragraph: 'Sed rutrum augue libero, id faucibus quam aliquet sed. Phasellus interdum orci quam, volutpat ornare eros rhoncus sed. Donec vestibulum leo a auctor convallis. In dignissim consectetur molestie. Vivamus interdum tempor dui, nec posuere augue consequat sit amet. Suspendisse quis semper quam. Nullam nec neque sem.',
    date: 'Jan 9, 2018'
  }
};

export default dummyContents;
