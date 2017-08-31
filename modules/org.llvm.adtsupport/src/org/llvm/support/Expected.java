/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */

package org.llvm.support;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.$tryClone;
import static org.clank.support.Native.$tryMove;
import static org.llvm.support.llvm.*;


/// Tagged union holding either a T or a Error.
///
/// This class parallels ErrorOr, but replaces error_code with Error. Since
/// Error cannot be copied, this class replaces getError() with
/// takeError(). It also adds an bool errorIsA<ErrT>() method for testing the
/// error class type.
/*template <class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::Expected">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 600,
 FQN="llvm::Expected", NM="_ZN4llvm8ExpectedE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm8ExpectedE")
//</editor-fold>
public class Expected</*class*/ T>  implements Destructors.ClassWithDestructor, Native.Native$Bool {
  /*friend template <class OtherT> class Expected*/
  private static /*const*/boolean isRef = false;
  // JAVA: typedef ReferenceStorage<typename std::remove_reference<T>::type> wrap
//  public final class wrap extends ReferenceStorage< std.remove_reference.type<T> >{ };
  
  // JAVA: typedef std::unique_ptr<ErrorInfoBase> error_type
//  public final class error_type extends std.unique_ptr<ErrorInfoBase>{ };
/*public:*/
  // JAVA: typedef typename std::conditional<isRef, wrap, T>::type storage_type
//  public final class storage_type extends ReferenceStorage<T>{ };
  // JAVA: typedef T value_type
//  public final class value_type extends T{ };
/*private:*/
  // JAVA: typedef typename std::remove_reference<T>::type &reference
//  public final class reference extends T /*&*/{ };
  // JAVA: typedef const typename std::remove_reference<T>::type &const_reference
//  public final class const_reference extends T /*&*/{ };
  // JAVA: typedef typename std::remove_reference<T>::type *pointer
//  public final class pointer extends T /*P*/{ };
  // JAVA: typedef const typename std::remove_reference<T>::type *const_pointer
//  public final class const_pointer extends T /*P*/{ };
/*public:*/
  /// Create an Expected<T> error value from the given Error.
  //<editor-fold defaultstate="collapsed" desc="llvm::Expected::Expected<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 619,
   FQN="llvm::Expected::Expected<T>", NM="_ZN4llvm8ExpectedC1ENS_5ErrorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm8ExpectedC1ENS_5ErrorE")
  //</editor-fold>
  public Expected(Error Err) {
    // : HasError(true), Checked(false) 
    //START JInit
    this.HasError = true;
    this.Checked = false;
    //END JInit
    assert (Err.$bool()) : "Cannot create Expected<T> from Error success value.";
    ///*FIXME: NEW_EXPR [NoNewFun]*/getErrorStorage() = /*new (getErrorStorage())*/ new Error(JD$Move.INSTANCE, std.move(Err));
    this.Unnamed_field.ErrorStorage.buffer = new Error(JD$Move.INSTANCE, std.move(Err));
  }

  
  /// Create an Expected<T> success value from the given OtherT value, which
  /// must be convertible to T.
  /*template <typename OtherT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Expected::Expected<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 633,
   FQN="llvm::Expected::Expected<T>", NM="Tpl__ZN4llvm8ExpectedC1EOT_PNSt9enable_ifIXsr14is_convertibleIS1_T_EE5valueEvE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=Tpl__ZN4llvm8ExpectedC1EOT_PNSt9enable_ifIXsr14is_convertibleIS1_T_EE5valueEvE4typeE")
  //</editor-fold>
  public </*typename*/ OtherT> Expected(JD$Convertible _dparam, final OtherT /*&&*/Val) {
    // : HasError(false), Checked(false) 
    //START JInit
    this.HasError = false;
    this.Checked = false;
    //END JInit
    ///*FIXME: NEW_EXPR [NoNewFun]*/getStorage() = /*new (getStorage())*/ new ReferenceStorage<T>(( std.<OtherT>forward(Val) ));
    this.Unnamed_field.TStorage.buffer =  $tryClone((T)Val);
  }
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED)
  public </*typename*/ OtherT> Expected(JD$ConvertibleMove _dparam, final OtherT /*&&*/Val) {
    // : HasError(false), Checked(false) 
    //START JInit
    this.HasError = false;
    this.Checked = false;
    //END JInit
    ///*FIXME: NEW_EXPR [NoNewFun]*/getStorage() = /*new (getStorage())*/ new ReferenceStorage<T>(( std.<OtherT>forward(Val) ));
    this.Unnamed_field.TStorage.buffer =  $tryMove((T)Val);
  }

  
  /// Move construct an Expected<T> value.
  //<editor-fold defaultstate="collapsed" desc="llvm::Expected::Expected<T>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 646,
   FQN="llvm::Expected::Expected<T>", NM="_ZN4llvm8ExpectedC1EONS_8ExpectedIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm8ExpectedC1EONS_8ExpectedIT_EE")
  //</editor-fold>
  public Expected(JD$Move _dparam, final Expected<T> /*&&*/Other) {
    moveConstruct(std.move(Other));
  }

  
  /// Move construct an Expected<T> value from an Expected<OtherT>, where OtherT
  /// must be convertible to T.
  /*template <class OtherT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Expected::Expected<T>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 651,
   FQN="llvm::Expected::Expected<T>", NM="Tpl__ZN4llvm8ExpectedC1EONS_8ExpectedIT_EEPNSt9enable_ifIXsr14is_convertibleIS2_T_EE5valueEvE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=Tpl__ZN4llvm8ExpectedC1EONS_8ExpectedIT_EEPNSt9enable_ifIXsr14is_convertibleIS2_T_EE5valueEvE4typeE")
  //</editor-fold>
  public </*class*/ OtherT> Expected(JD$Convertible _dparam, final Expected<OtherT> /*&&*/Other) {
    moveConstruct(std.move(Other));
  }

  
  /// Move construct an Expected<T> value from an Expected<OtherT>, where OtherT
  /// isn't convertible to T.
  /*template <class OtherT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Expected::Expected<T>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 660,
   FQN="llvm::Expected::Expected<T>", NM="Tpl__ZN4llvm8ExpectedC1EONS_8ExpectedIT_EEPNSt9enable_ifIXntsr3std14is_convertibleIS2_T_EE5valueEvE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=Tpl__ZN4llvm8ExpectedC1EONS_8ExpectedIT_EEPNSt9enable_ifIXntsr3std14is_convertibleIS2_T_EE5valueEvE4typeE")
  //</editor-fold>
  public /*explicit*/ </*class*/ OtherT> Expected(JD$NotConvertible _dparam, final Expected<OtherT> /*&&*/Other) {
    moveConstruct(std.move(Other));
  }

  
  /// Move-assign from another Expected<T>.
  //<editor-fold defaultstate="collapsed" desc="llvm::Expected::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 668,
   FQN="llvm::Expected::operator=", NM="_ZN4llvm8ExpectedaSEONS_8ExpectedIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm8ExpectedaSEONS_8ExpectedIT_EE")
  //</editor-fold>
  public Expected<T> /*&*/ $assignMove(final Expected<T> /*&&*/Other) {
    moveAssign(std.move(Other));
    return /*Deref*/this;
  }

  
  /// Destroy an Expected<T>.
  //<editor-fold defaultstate="collapsed" desc="llvm::Expected::~Expected<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 674,
   FQN="llvm::Expected::~Expected<T>", NM="_ZN4llvm8ExpectedD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm8ExpectedD0Ev")
  //</editor-fold>
  public void $destroy() {
    assertIsChecked();
    if (!HasError) {
      //getStorage()->~ReferenceStorage<T>();
      Destructors.$destroy(this.Unnamed_field.ErrorStorage.buffer);
    } else {
      //getErrorStorage()->~std.unique_ptr<ErrorInfoBase>();
      Destructors.$destroy(this.Unnamed_field.TStorage.buffer);
    }
  }

  
  /// \brief Return false if there is an error.
  //<editor-fold defaultstate="collapsed" desc="llvm::Expected::operator bool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 683,
   FQN="llvm::Expected::operator bool", NM="_ZN4llvm8ExpectedcvbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm8ExpectedcvbEv")
  //</editor-fold>
  public boolean $bool() {
    Checked = !HasError;
    return !HasError;
  }

  
  /// \brief Returns a reference to the stored T value.
  //<editor-fold defaultstate="collapsed" desc="llvm::Expected::get">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 691,
   FQN="llvm::Expected::get", NM="_ZN4llvm8Expected3getEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm8Expected3getEv")
  //</editor-fold>
  public T /*&*/ get() {
    assertIsChecked();
    //return /*Deref*/getStorage();
    return (T)this.Unnamed_field.TStorage.buffer;
  }

  
  /// \brief Returns a const reference to the stored T value.
  //<editor-fold defaultstate="collapsed" desc="llvm::Expected::get">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 697,
   FQN="llvm::Expected::get", NM="_ZNK4llvm8Expected3getEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZNK4llvm8Expected3getEv")
  //</editor-fold>
  public T /*&*/ get$Const() /*const*/ {
    assertIsChecked();
    //return ((/*const_cast*/Expected<T> /*P*/ )(this)).get();
    return (T)this.Unnamed_field.TStorage.buffer;
  }

  
  /// \brief Check that this Expected<T> is an error of type ErrT.
  /*template <typename ErrT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Expected::errorIsA">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 703,
   FQN="llvm::Expected::errorIsA", NM="Tpl__ZNK4llvm8Expected8errorIsAEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=Tpl__ZNK4llvm8Expected8errorIsAEv")
  //</editor-fold>
  public </*typename*/ ErrT> boolean errorIsA(Class<T> cls) /*const*/ {
    return HasError && getErrorStorage().$star()./*template */<ErrT>isA(cls);
  }

  
  /// \brief Take ownership of the stored error.
  /// After calling this the Expected<T> is in an indeterminate state that can
  /// only be safely destructed. No further calls (beside the destructor) should
  /// be made on the Expected<T> vaule.
  //<editor-fold defaultstate="collapsed" desc="llvm::Expected::takeError">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 711,
   FQN="llvm::Expected::takeError", NM="_ZN4llvm8Expected9takeErrorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm8Expected9takeErrorEv")
  //</editor-fold>
  public Error takeError() {
    Checked = true;
    return HasError ? new Error(std.move($Deref(getErrorStorage()))) : Error.success();
  }

  
  /// \brief Returns a pointer to the stored T value.
  //<editor-fold defaultstate="collapsed" desc="llvm::Expected::operator->">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 719,
   FQN="llvm::Expected::operator->", NM="_ZN4llvm8ExpectedptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm8ExpectedptEv")
  //</editor-fold>
  public  T /*P*/ /*P*/ $arrow() {
    assertIsChecked();
    //return toPointer(getStorage());
    return getStorage();
  }

  
  /// \brief Returns a const pointer to the stored T value.
  //<editor-fold defaultstate="collapsed" desc="llvm::Expected::operator->">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 725,
   FQN="llvm::Expected::operator->", NM="_ZNK4llvm8ExpectedptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZNK4llvm8ExpectedptEv")
  //</editor-fold>
  public /*const*/ T /*P*/ /*P*/ $arrow$Const() /*const*/ {
    assertIsChecked();
    //return toPointer(getStorage());
    return getStorage();
  }

  
  /// \brief Returns a reference to the stored T value.
  //<editor-fold defaultstate="collapsed" desc="llvm::Expected::operator*">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 731,
   FQN="llvm::Expected::operator*", NM="_ZN4llvm8ExpecteddeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm8ExpecteddeEv")
  //</editor-fold>
  public T /*&*/ $star() {
    assertIsChecked();
    return $Deref(getStorage());
  }

  
  /// \brief Returns a const reference to the stored T value.
  //<editor-fold defaultstate="collapsed" desc="llvm::Expected::operator*">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 737,
   FQN="llvm::Expected::operator*", NM="_ZNK4llvm8ExpecteddeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZNK4llvm8ExpecteddeEv")
  //</editor-fold>
  public T /*&*/ $star$Const() /*const*/ {
    assertIsChecked();
    return $Deref(getStorage());
  }

/*private:*/
  /*template <class T1> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Expected::compareThisIfSameType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 744,
   FQN="llvm::Expected::compareThisIfSameType", NM="Tpl__ZN4llvm8Expected21compareThisIfSameTypeERKT_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=Tpl__ZN4llvm8Expected21compareThisIfSameTypeERKT_S3_")
  //</editor-fold>
  private static </*class*/ T1> boolean compareThisIfSameType_T$C$R(final /*const*/ T1 /*&*/ a, final /*const*/ T1 /*&*/ b) {
    return Native.$eq($AddrOf(a), $AddrOf(b));
  }

  
  /*template <class T1, class T2> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Expected::compareThisIfSameType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 749,
   FQN="llvm::Expected::compareThisIfSameType", NM="Tpl__ZN4llvm8Expected21compareThisIfSameTypeERKT_RKT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=Tpl__ZN4llvm8Expected21compareThisIfSameTypeERKT_RKT0_")
  //</editor-fold>
  private static </*class*/ T1, /*class*/ T2> boolean compareThisIfSameType_T$C$R_T1$C$R(final /*const*/ T1 /*&*/ a, final /*const*/ T2 /*&*/ b) {
    return false;
  }

  
  /*template <class OtherT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Expected::moveConstruct">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 753,
   FQN="llvm::Expected::moveConstruct", NM="Tpl__ZN4llvm8Expected13moveConstructEONS_8ExpectedIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=Tpl__ZN4llvm8Expected13moveConstructEONS_8ExpectedIT_EE")
  //</editor-fold>
  private </*class*/ OtherT> void moveConstruct(final Expected<OtherT> /*&&*/Other) {
    HasError = Other.HasError;
    Checked = false;
    Other.Checked = true;
    if (!HasError) {
      ///*FIXME: NEW_EXPR [NoNewFun]*/getStorage() = /*new (getStorage())*/ new ReferenceStorage<T>(( std.move(/*Deref*/Other.getStorage()) ));
      this.Unnamed_field.TStorage.buffer = $tryMove(std.move($Deref(Other.getStorage())));
    } else {
      ///*FIXME: NEW_EXPR [NoNewFun]*/getErrorStorage() = /*new (getErrorStorage())*/ new std.unique_ptr<ErrorInfoBase>(( std.move(/*Deref*/Other.getErrorStorage()) ));
      this.Unnamed_field.ErrorStorage.buffer = new std.unique_ptr<ErrorInfoBase>(( std.move($Deref(Other.getErrorStorage())) ));
    }
  }

  
  /*template <class OtherT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Expected::moveAssign">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 767,
   FQN="llvm::Expected::moveAssign", NM="Tpl__ZN4llvm8Expected10moveAssignEONS_8ExpectedIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=Tpl__ZN4llvm8Expected10moveAssignEONS_8ExpectedIT_EE")
  //</editor-fold>
  private </*class*/ OtherT> void moveAssign(final Expected<OtherT> /*&&*/Other) {
    assertIsChecked();
    if (compareThisIfSameType_T$C$R(/*Deref*/this, Other)) {
      return;
    }
    //this->~Expected<T>();
    $destroy();
    ///*FIXME: NEW_EXPR [NoNewFun]*/this = /*new (this)*/ new Expected<T>(( std.move(Other) ));
    this.Checked = Other.Checked;
    this.HasError = Other.HasError;
    this.Unnamed_field.ErrorStorage.buffer = Other.Unnamed_field.ErrorStorage.buffer;
    this.Unnamed_field.TStorage.buffer = Other.Unnamed_field.TStorage.buffer;
    Other.Unnamed_field.ErrorStorage.buffer = null;
    Other.Unnamed_field.TStorage.buffer = null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Expected::toPointer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 777,
   FQN="llvm::Expected::toPointer", NM="_ZN4llvm8Expected9toPointerEPNSt16remove_referenceIT_E4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm8Expected9toPointerEPNSt16remove_referenceIT_E4typeE")
  //</editor-fold>
  private  T /*P*/ /*P*/ toPointer_type$T$P$P(T /*P*/ /*P*/ Val) {
    return Val;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Expected::toPointer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 779,
   FQN="llvm::Expected::toPointer", NM="_ZNK4llvm8Expected9toPointerEPKNSt16remove_referenceIT_E4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZNK4llvm8Expected9toPointerEPKNSt16remove_referenceIT_E4typeE")
  //</editor-fold>
  private /*const*/  T /*P*/ /*P*/ toPointer_type$T$C$P$P$Const(/*const*/  T /*P*/ /*P*/ Val) /*const*/ {
    return Val;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Expected::toPointer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 781,
   FQN="llvm::Expected::toPointer", NM="_ZN4llvm8Expected9toPointerEPNS_16ReferenceStorageINSt16remove_referenceIT_E4typeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm8Expected9toPointerEPNS_16ReferenceStorageINSt16remove_referenceIT_E4typeEEE")
  //</editor-fold>
  private  T /*P*/ /*P*/ toPointer_ReferenceStorage$type$P(ReferenceStorage< T > /*P*/ Val) {
    return $AddrOf(Val.get());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Expected::toPointer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 783,
   FQN="llvm::Expected::toPointer", NM="_ZNK4llvm8Expected9toPointerEPKNS_16ReferenceStorageINSt16remove_referenceIT_E4typeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZNK4llvm8Expected9toPointerEPKNS_16ReferenceStorageINSt16remove_referenceIT_E4typeEEE")
  //</editor-fold>
  private /*const*/  T /*P*/ /*P*/ toPointer_ReferenceStorage$type$C$P$Const(/*const*/ ReferenceStorage< T > /*P*/ Val) /*const*/ {
    return $AddrOf(Val.get());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Expected::getStorage">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 785,
   FQN="llvm::Expected::getStorage", NM="_ZN4llvm8Expected10getStorageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm8Expected10getStorageEv")
  //</editor-fold>
  private T /*P*/ getStorage() {
    assert (!HasError) : "Cannot get value when an error exists!";
    return (T) Unnamed_field.TStorage.buffer;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Expected::getStorage">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 790,
   FQN="llvm::Expected::getStorage", NM="_ZNK4llvm8Expected10getStorageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZNK4llvm8Expected10getStorageEv")
  //</editor-fold>
  private T /*P*/ getStorage$Const() /*const*/ {
    assert (!HasError) : "Cannot get value when an error exists!";
    return (T) Unnamed_field.TStorage.buffer;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Expected::getErrorStorage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 795,
   FQN="llvm::Expected::getErrorStorage", NM="_ZN4llvm8Expected15getErrorStorageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm8Expected15getErrorStorageEv")
  //</editor-fold>
  private std.unique_ptr<ErrorInfoBase> /*P*/ getErrorStorage() {
    assert (HasError) : "Cannot get error when a value exists!";
    return ((std.unique_ptr<ErrorInfoBase> /*P*/ )reinterpret_cast(std.unique_ptr.class, Unnamed_field.ErrorStorage.buffer));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Expected::assertIsChecked">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 800,
   FQN="llvm::Expected::assertIsChecked", NM="_ZN4llvm8Expected15assertIsCheckedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm8Expected15assertIsCheckedEv")
  //</editor-fold>
  private void assertIsChecked() {
    if (!Checked) {
      dbgs().$out(/*KEEP_STR*/"Expected<T> must be checked before access or destruction.\n");
      if (HasError) {
        dbgs().$out(/*KEEP_STR*/"Unchecked Expected<T> contained error:\n");
        //TODO: uncomment line
        //(/*Deref*/getErrorStorage()).log(dbgs());
      } else {
        dbgs().$out(/*KEEP_STR*/"Expected<T> value was in success state. (Note: Expected<T> values in success mode must still be checked prior to being destroyed).\n");
      }
      abort();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Expected::(anonymous)">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 816,
   FQN="llvm::Expected::(anonymous)", NM="_ZN4llvm8ExpectedE_Unnamed_union1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm8ExpectedE_Unnamed_union1")
  //</editor-fold>
  private static class /*union*/ Unnamed_union1<T> {
    public AlignedCharArrayUnion<ReferenceStorage<T>, T> TStorage = new AlignedCharArrayUnion<>();
    public AlignedCharArrayUnion1<std.unique_ptr<ErrorInfoBase>> ErrorStorage = new AlignedCharArrayUnion1<>();
    
    @Override public String toString() {
      return "" + "TStorage=" + TStorage // NOI18N
                + ", ErrorStorage=" + ErrorStorage; // NOI18N
    }
  };
  private Unnamed_union1 Unnamed_field = new Unnamed_union1();
  private /*JBIT bool*/ boolean HasError /*: 1*/;
  private /*JBIT bool*/ boolean Checked /*: 1*/;
  
  @Override public String toString() {
    return "" + "Unnamed_field=" + Unnamed_field // NOI18N
              + ", HasError=" + HasError // NOI18N
              + ", Checked=" + Checked; // NOI18N
  }
}
