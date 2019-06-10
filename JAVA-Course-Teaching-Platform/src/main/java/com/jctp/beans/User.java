/*
 * Copyright 2004, 2005, 2006 Acegi Technology Pty Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jctp.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Function;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Assert;

/**
 * Models core user information retrieved by a {@link UserDetailsService}.
 * <p>
 * Developers may use this class directly, subclass it, or write their own
 * {@link UserDetails} implementation from scratch.
 * <p>
 * {@code equals} and {@code hashcode} implementations are based on the {@code username}
 * property only, as the intention is that lookups of the same user principal object (in a
 * user registry, for example) will match where the objects represent the same user, not
 * just when all the properties (authorities, password for example) are the same.
 * <p>
 * Note that this implementation is not immutable. It implements the
 * {@code CredentialsContainer} interface, in order to allow the password to be erased
 * after authentication. This may cause side-effects if you are storing instances
 * in-memory and reusing them. If so, make sure you return a copy from your
 * {@code UserDetailsService} each time it is invoked.
 *
 * @author Ben Alex
 * @author Luke Taylor
 */
public class User implements UserDetails, CredentialsContainer {

	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

	private static final Log logger = LogFactory.getLog(User.class);

	// ~ Instance fields
	// ================================================================================================
	private String password;
	private String username;
	private Set<GrantedAuthority> authorities;
	private boolean accountNonExpired=true;
	private boolean accountNonLocked=true;
	private boolean credentialsNonExpired=true;
	private boolean enabled=true;
	
	//--------------------------------------------------
	//mydata
	
	private int id;
	private String name;
	
	@Pattern(regexp = "^男|女$",message = "性别必须是男或女")
	private String sex;
	
	private String workNo;
	
	@Pattern(regexp = "^[1][3,4,5,6,7,8][0-9]{9}$",message = "电话号码不正确")
	private String phone;
	private int roleId;
	private String roleName;
	private int state;
	private int classId;
	private String className;
	
	@NotBlank(message = "密码不为空")
	@Size(max=16,min=8,message = "密码长度在8-16位")
	@Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$",message = "密码需要同时含有数字和字母")
	private String titleImg;
	
	// ~ Constructors
	// ===================================================================================================
	public User() {
		
	}
	public int getId() {
		return id;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getWorkNo() {
		return workNo;
	}

	public void setWorkNo(String workNo) {
		this.username=workNo;
		this.workNo = workNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getTitleImg() {
		return titleImg;
	}

	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Log getLogger() {
		return logger;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	//--------------------------------------------------
	/**
	 * Calls the more complex constructor with all boolean arguments set to {@code true}.
	 */
	
	public User(String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this(username, password, true, true, true, true, authorities);
	}
	 
	/**
	 * Construct the <code>User</code> with the details required by
	 * {@link org.springframework.security.authentication.dao.DaoAuthenticationProvider}.
	 *
	 * @param username the username presented to the
	 * <code>DaoAuthenticationProvider</code>
	 * @param password the password that should be presented to the
	 * <code>DaoAuthenticationProvider</code>
	 * @param enabled set to <code>true</code> if the user is enabled
	 * @param accountNonExpired set to <code>true</code> if the account has not expired
	 * @param credentialsNonExpired set to <code>true</code> if the credentials have not
	 * expired
	 * @param accountNonLocked set to <code>true</code> if the account is not locked
	 * @param authorities the authorities that should be granted to the caller if they
	 * presented the correct username and password and the user is enabled. Not null.
	 *
	 * @throws IllegalArgumentException if a <code>null</code> value was passed either as
	 * a parameter or as an element in the <code>GrantedAuthority</code> collection
	 */
	
	public User(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {

		

		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.accountNonExpired = accountNonExpired;
		this.credentialsNonExpired = credentialsNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
	}

	
	// ~ Methods
	// ========================================================================================================

	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		if (((username == null) || "".equals(username)) || (password == null)) {
			throw new IllegalArgumentException(
					"Cannot pass null or empty values to constructor");
		}
		this.username=username;
	}
	public boolean isEnabled() {
		return enabled;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void eraseCredentials() {
		password = null;
	}

	private static SortedSet<GrantedAuthority> sortAuthorities(
			Collection<? extends GrantedAuthority> authorities) {
		Assert.notNull(authorities, "Cannot pass a null GrantedAuthority collection");
		// Ensure array iteration order is predictable (as per
		// UserDetails.getAuthorities() contract and SEC-717)
		SortedSet<GrantedAuthority> sortedAuthorities = new TreeSet<>(
				new AuthorityComparator());

		for (GrantedAuthority grantedAuthority : authorities) {
			Assert.notNull(grantedAuthority,
					"GrantedAuthority list cannot contain any null elements");
			sortedAuthorities.add(grantedAuthority);
		}

		return sortedAuthorities;
	}

	private static class AuthorityComparator implements Comparator<GrantedAuthority>,
			Serializable {
		private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

		public int compare(GrantedAuthority g1, GrantedAuthority g2) {
			// Neither should ever be null as each entry is checked before adding it to
			// the set.
			// If the authority is null, it is a custom authority and should precede
			// others.
			if (g2.getAuthority() == null) {
				return -1;
			}

			if (g1.getAuthority() == null) {
				return 1;
			}

			return g1.getAuthority().compareTo(g2.getAuthority());
		}
	}

	/**
	 * Returns {@code true} if the supplied object is a {@code User} instance with the
	 * same {@code username} value.
	 * <p>
	 * In other words, the objects are equal if they have the same username, representing
	 * the same principal.
	 */
	@Override
	public boolean equals(Object rhs) {
		if (rhs instanceof User) {
			return username.equals(((User) rhs).username);
		}
		return false;
	}

	/**
	 * Returns the hashcode of the {@code username}.
	 */
	@Override
	public int hashCode() {
		return username.hashCode();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()).append(": ");
		sb.append("Username: ").append(this.username).append("; ");
		sb.append("Password: [PROTECTED]; ");
		sb.append("Enabled: ").append(this.enabled).append("; ");
		sb.append("AccountNonExpired: ").append(this.accountNonExpired).append("; ");
		sb.append("credentialsNonExpired: ").append(this.credentialsNonExpired)
				.append("; ");
		sb.append("AccountNonLocked: ").append(this.accountNonLocked).append("; ");

		if (!authorities.isEmpty()) {
			sb.append("Granted Authorities: ");

			boolean first = true;
			for (GrantedAuthority auth : authorities) {
				if (!first) {
					sb.append(",");
				}
				first = false;

				sb.append(auth);
			}
		}
		else {
			sb.append("Not granted any authorities");
		}

		return sb.toString();
	}

	/**
	 * Creates a UserBuilder with a specified user name
	 *
	 * @param username the username to use
	 * @return the UserBuilder
	 */
	public static UserBuilder withUsername(String username) {
		return builder().username(username);
	}

	/**
	 * Creates a UserBuilder
	 *
	 * @return the UserBuilder
	 */
	public static UserBuilder builder() {
		return new UserBuilder();
	}

	/**
	 * <p>
	 * <b>WARNING:</b> This method is considered unsafe for production and is only intended
	 * for sample applications.
	 * </p>
	 * <p>
	 * Creates a user and automatically encodes the provided password using
	 * {@code PasswordEncoderFactories.createDelegatingPasswordEncoder()}. For example:
	 * </p>
	 *
	 * <pre>
	 * <code>
	 * UserDetails user = User.withDefaultPasswordEncoder()
	 *     .username("user")
	 *     .password("password")
	 *     .roles("USER")
	 *     .build();
	 * // outputs {bcrypt}$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG
	 * System.out.println(user.getPassword());
	 * </code>
	 * </pre>
	 *
	 * This is not safe for production (it is intended for getting started experience)
	 * because the password "password" is compiled into the source code and then is
	 * included in memory at the time of creation. This means there are still ways to
	 * recover the plain text password making it unsafe. It does provide a slight
	 * improvement to using plain text passwords since the UserDetails password is
	 * securely hashed. This means if the UserDetails password is accidentally exposed,
	 * the password is securely stored.
	 *
	 * In a production setting, it is recommended to hash the password ahead of time.
	 * For example:
	 *
	 * <pre>
	 * <code>
	 * PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	 * // outputs {bcrypt}$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG
	 * // remember the password that is printed out and use in the next step
	 * System.out.println(encoder.encode("password"));
	 * </code>
	 * </pre>
	 *
	 * <pre>
	 * <code>
	 * UserDetails user = User.withUsername("user")
	 *     .password("{bcrypt}$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG")
	 *     .roles("USER")
	 *     .build();
	 * </code>
	 * </pre>
	 *
	 * @return a UserBuilder that automatically encodes the password with the default
	 * PasswordEncoder
	 * @deprecated Using this method is not considered safe for production, but is
	 * acceptable for demos and getting started. For production purposes, ensure the
	 * password is encoded externally. See the method Javadoc for additional details.
	 * There are no plans to remove this support. It is deprecated to indicate
	 * that this is considered insecure for production purposes.
	 */
	@Deprecated
	public static UserBuilder withDefaultPasswordEncoder() {
		logger.warn("User.withDefaultPasswordEncoder() is considered unsafe for production and is only intended for sample applications.");
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return builder().passwordEncoder(encoder::encode);
	}

	public static UserBuilder withUserDetails(UserDetails userDetails) {
		return withUsername(userDetails.getUsername())
			.password(userDetails.getPassword())
			.accountExpired(!userDetails.isAccountNonExpired())
			.accountLocked(!userDetails.isAccountNonLocked())
			.authorities(userDetails.getAuthorities())
			.credentialsExpired(!userDetails.isCredentialsNonExpired())
			.disabled(!userDetails.isEnabled());
	}

	/**
	 * Builds the user to be added. At minimum the username, password, and authorities
	 * should provided. The remaining attributes have reasonable defaults.
	 */
	public static class UserBuilder {
		private String username;
		private String password;
		private List<GrantedAuthority> authorities;
		private boolean accountExpired;
		private boolean accountLocked;
		private boolean credentialsExpired;
		private boolean disabled;
		private Function<String, String> passwordEncoder = password -> password;

		/**
		 * Creates a new instance
		 */
		private UserBuilder() {
		}

		/**
		 * Populates the username. This attribute is required.
		 *
		 * @param username the username. Cannot be null.
		 * @return the {@link UserBuilder} for method chaining (i.e. to populate
		 * additional attributes for this user)
		 */
		public UserBuilder username(String username) {
			Assert.notNull(username, "username cannot be null");
			this.username = username;
			return this;
		}

		/**
		 * Populates the password. This attribute is required.
		 *
		 * @param password the password. Cannot be null.
		 * @return the {@link UserBuilder} for method chaining (i.e. to populate
		 * additional attributes for this user)
		 */
		public UserBuilder password(String password) {
			Assert.notNull(password, "password cannot be null");
			this.password = password;
			return this;
		}

		/**
		 * Encodes the current password (if non-null) and any future passwords supplied
		 * to {@link #password(String)}.
		 *
		 * @param encoder the encoder to use
		 * @return the {@link UserBuilder} for method chaining (i.e. to populate
		 * additional attributes for this user)
		 */
		public UserBuilder passwordEncoder(Function<String, String> encoder) {
			Assert.notNull(encoder, "encoder cannot be null");
			this.passwordEncoder = encoder;
			return this;
		}

		/**
		 * Populates the roles. This method is a shortcut for calling
		 * {@link #authorities(String...)}, but automatically prefixes each entry with
		 * "ROLE_". This means the following:
		 *
		 * <code>
		 *     builder.roles("USER","ADMIN");
		 * </code>
		 *
		 * is equivalent to
		 *
		 * <code>
		 *     builder.authorities("ROLE_USER","ROLE_ADMIN");
		 * </code>
		 *
		 * <p>
		 * This attribute is required, but can also be populated with
		 * {@link #authorities(String...)}.
		 * </p>
		 *
		 * @param roles the roles for this user (i.e. USER, ADMIN, etc). Cannot be null,
		 * contain null values or start with "ROLE_"
		 * @return the {@link UserBuilder} for method chaining (i.e. to populate
		 * additional attributes for this user)
		 */
		public UserBuilder roles(String... roles) {
			List<GrantedAuthority> authorities = new ArrayList<>(
					roles.length);
			for (String role : roles) {
				Assert.isTrue(!role.startsWith("ROLE_"), () -> role
						+ " cannot start with ROLE_ (it is automatically added)");
				authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
			}
			return authorities(authorities);
		}

		/**
		 * Populates the authorities. This attribute is required.
		 *
		 * @param authorities the authorities for this user. Cannot be null, or contain
		 * null values
		 * @return the {@link UserBuilder} for method chaining (i.e. to populate
		 * additional attributes for this user)
		 * @see #roles(String...)
		 */
		public UserBuilder authorities(GrantedAuthority... authorities) {
			return authorities(Arrays.asList(authorities));
		}

		/**
		 * Populates the authorities. This attribute is required.
		 *
		 * @param authorities the authorities for this user. Cannot be null, or contain
		 * null values
		 * @return the {@link UserBuilder} for method chaining (i.e. to populate
		 * additional attributes for this user)
		 * @see #roles(String...)
		 */
		public UserBuilder authorities(Collection<? extends GrantedAuthority> authorities) {
			this.authorities = new ArrayList<>(authorities);
			return this;
		}

		/**
		 * Populates the authorities. This attribute is required.
		 *
		 * @param authorities the authorities for this user (i.e. ROLE_USER, ROLE_ADMIN,
		 * etc). Cannot be null, or contain null values
		 * @return the {@link UserBuilder} for method chaining (i.e. to populate
		 * additional attributes for this user)
		 * @see #roles(String...)
		 */
		public UserBuilder authorities(String... authorities) {
			return authorities(AuthorityUtils.createAuthorityList(authorities));
		}

		/**
		 * Defines if the account is expired or not. Default is false.
		 *
		 * @param accountExpired true if the account is expired, false otherwise
		 * @return the {@link UserBuilder} for method chaining (i.e. to populate
		 * additional attributes for this user)
		 */
		public UserBuilder accountExpired(boolean accountExpired) {
			this.accountExpired = accountExpired;
			return this;
		}

		/**
		 * Defines if the account is locked or not. Default is false.
		 *
		 * @param accountLocked true if the account is locked, false otherwise
		 * @return the {@link UserBuilder} for method chaining (i.e. to populate
		 * additional attributes for this user)
		 */
		public UserBuilder accountLocked(boolean accountLocked) {
			this.accountLocked = accountLocked;
			return this;
		}

		/**
		 * Defines if the credentials are expired or not. Default is false.
		 *
		 * @param credentialsExpired true if the credentials are expired, false otherwise
		 * @return the {@link UserBuilder} for method chaining (i.e. to populate
		 * additional attributes for this user)
		 */
		public UserBuilder credentialsExpired(boolean credentialsExpired) {
			this.credentialsExpired = credentialsExpired;
			return this;
		}

		/**
		 * Defines if the account is disabled or not. Default is false.
		 *
		 * @param disabled true if the account is disabled, false otherwise
		 * @return the {@link UserBuilder} for method chaining (i.e. to populate
		 * additional attributes for this user)
		 */
		public UserBuilder disabled(boolean disabled) {
			this.disabled = disabled;
			return this;
		}

		public UserDetails build() {
			String encodedPassword = this.passwordEncoder.apply(password);
			return new User(username, encodedPassword, !disabled, !accountExpired,
					!credentialsExpired, !accountLocked, authorities);
		}
	}
}
