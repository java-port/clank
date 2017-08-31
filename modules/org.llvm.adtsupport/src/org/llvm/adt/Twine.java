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

package org.llvm.adt;

import static org.clank.support.Native.$Deref;
import java.util.Objects;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;


/// Twine - A lightweight data structure for efficiently representing the
/// concatenation of temporary values as strings.
///
/// A Twine is a kind of rope, it represents a concatenated string using a
/// binary-tree, where the string is the preorder of the nodes. Since the
/// Twine can be efficiently rendered into a buffer when its result is used,
/// it avoids the cost of generating temporary values for intermediate string
/// results -- particularly in cases when the Twine result is never
/// required. By explicitly tracking the type of leaf nodes, we can also avoid
/// the creation of temporary strings for conversions operations (such as
/// appending an integer to a string).
///
/// A Twine is not intended for use directly and should not be stored, its
/// implementation relies on the ability to store pointers to temporary stack
/// objects which may be deallocated at the end of a statement. Twines should
/// only be used accepted as const references in arguments, when an API wishes
/// to accept possibly-concatenated strings.
///
/// Twines support a special 'null' value, which always concatenates to form
/// itself, and renders as an empty string. This can be returned from APIs to
/// effectively nullify any concatenations performed on the result.
///
/// \b Implementation
///
/// Given the nature of a Twine, it is not possible for the Twine's
/// concatenation method to construct interior nodes; the result must be
/// represented inside the returned value. For this reason a Twine object
/// actually holds two values, the left- and right-hand sides of a
/// concatenation. We also have nullary Twine objects, which are effectively
/// sentinel values that represent empty strings.
///
/// Thus, a Twine can effectively have zero, one, or two children. The \see
/// isNullary(), \see isUnary(), and \see isBinary() predicates exist for
/// testing the number of children.
///
/// We maintain a number of invariants on Twine objects (FIXME: Why):
///  - Nullary twines are always represented with their Kind on the left-hand
///    side, and the Empty kind on the right-hand side.
///  - Unary twines are always represented with the value on the left-hand
///    side, and the Empty kind on the right-hand side.
///  - If a Twine has another Twine as a child, that child should always be
///    binary (otherwise it could have been folded into the parent).
///
/// These invariants are check by \see isValid().
///
/// \b Efficiency Considerations
///
/// The Twine is designed to yield efficient and small code for common
/// situations. For this reason, the concat() method is inlined so that
/// concatenations of leaf nodes can be optimized into stores directly into a
/// single stack allocated object.
///
/// In practice, not all compilers can be trusted to optimize concat() fully,
/// so we provide two additional methods (and accompanying operator+
/// overloads) to guarantee that particularly important cases (cstring plus
/// StringRef) codegen as desired.
//<editor-fold defaultstate="collapsed" desc="llvm::Twine">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 79,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 81,
 FQN = "llvm::Twine", NM = "_ZN4llvm5TwineE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm5TwineE")
//</editor-fold>
public final class Twine implements Native.NativePOD<Twine> {
  public static final Twine T$EMPTY = new Twine();// new Twine("")
  public static final Twine T$SPACE = new Twine(StringRef.R$SPACE);// new Twine(" ") or new Twine(' ')
  public static final Twine T$MINUS = new Twine(StringRef.R$MINUS);// new Twine("-") or new Twine('-')
  public static final Twine T$PLUS = new Twine(StringRef.R$PLUS);// new Twine("+") or new Twine('+')
  public static final Twine T$DOT = new Twine(StringRef.R$DOT);// new Twine(".") or new Twine('.')
  public static final Twine T$0 = new Twine(StringRef.R$0);// new Twine("0") or new Twine(0)
  public static final Twine T$1 = new Twine(StringRef.R$1);// new Twine("1") or new Twine(1)
  public static final Twine T$2 = new Twine(StringRef.R$2);// new Twine("2") or new Twine(2)
  public static final Twine T$3 = new Twine(StringRef.R$3);// new Twine("3") or new Twine(3)
  public static final Twine T$SLASH = new Twine(StringRef.R$SLASH);// new Twine("/") or new Twine('/')
  public static final Twine T$DOT_DOT = new Twine(StringRef.R$DOT_DOT);// new Twine("..")
    
  //////////////////////////////////////////////////////////////////////////////
  // other commonly used Twines
  public static final Twine T$scratch_space_marker = new Twine(StringRef.R$scratch_space_marker);
  public static final /*const*/Twine T$invalid_marker/*J*/= new Twine(StringRef.R$invalid_marker);
  public static final /*const*/Twine T$built_in_marker/*J*/= new Twine(StringRef.R$built_in_marker);
    
  public static Twine $new(StringRef stringRef) {
//      if (StringRef.EMPTY.equals(stringRef)) {
//          return EMPTY;
//      } else if (StringRef.SPACE.equals(stringRef)) {
//          return SPACE;
//      } else if (StringRef.R$MINUS.equals(stringRef)) {
//          return MINUS;
//      } else if (StringRef.R$PLUS.equals(stringRef)) {
//          return PLUS;
//      } else if (StringRef.R$DOT.equals(stringRef)) {
//          return DOT;
//      } else if (StringRef.R$0.equals(stringRef)) {
//          return ZERO;
//      } else if (StringRef.R$1.equals(stringRef)) {
//          return ONE;
//      } else if (StringRef.R$2.equals(stringRef)) {
//          return TWO;
//      } else if (StringRef.R$3.equals(stringRef)) {
//          return THREE;
//      }
      return new Twine(stringRef);
  }

  public Twine(JD$Long$C INSTANCE, long TargetLocation) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  public Twine(JD$ConstULLongRef INSTANCE, long FragmentOffset) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
  /// NodeKind - Represent the type of an argument.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::NodeKind">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 81,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 83,
   FQN="llvm::Twine::NodeKind", NM="_ZN4llvm5Twine8NodeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm5Twine8NodeKindE")
  //</editor-fold>
  private static final class/*enum*/ NodeKind/* : unsigned char*/ {
    /// An empty string; the result of concatenating anything with it is also
    /// empty.
    public static final char NullKind = 0;

    /// The empty string.
    public static final char EmptyKind = NullKind + 1;

    /// A pointer to a Twine instance.
    public static final char TwineKind = EmptyKind + 1;

    /// A pointer to a C string instance.
    public static final char CStringKind = TwineKind + 1;

    /// A pointer to an std::string instance.
    public static final char StdStringKind = CStringKind + 1;

    /// A pointer to a StringRef instance.
    public static final char StringRefKind = StdStringKind + 1;

    /// A pointer to a SmallString instance.
    public static final char SmallStringKind = StringRefKind + 1;

    /// A char value, to render as a character.
    public static final char CharKind = SmallStringKind + 1;

    /// An unsigned int value, to render as an unsigned decimal integer.
    public static final char DecUIKind = CharKind + 1;

    /// An int value, to render as a signed decimal integer.
    public static final char DecIKind = DecUIKind + 1;

    /// A pointer to an unsigned long value, to render as an unsigned decimal
    /// integer.
    public static final char DecULKind = DecIKind + 1;

    /// A pointer to a long value, to render as a signed decimal integer.
    public static final char DecLKind = DecULKind + 1;

    /// A pointer to an unsigned long long value, to render as an unsigned
    /// decimal integer.
    public static final char DecULLKind = DecLKind + 1;

    /// A pointer to a long long value, to render as a signed decimal integer.
    public static final char DecLLKind = DecULLKind + 1;

    /// A pointer to a uint64_t value, to render as an unsigned hexadecimal
    /// integer.
    public static final char UHexKind = DecLLKind + 1;
  }
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::Child">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 132,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 133,
   FQN = "llvm::Twine::Child", NM = "_ZN4llvm5Twine5ChildE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm5Twine5ChildE")
  //</editor-fold>
  private static class/*union*/ Child {
      // JAVA: constains any reference
      private Object refVal;
      // JAVA: contains any numeric value
      private long numVal;
//    public /*const*/Twine /*P*/ twine;
//    public /*const*/char$ptr/*char P*/ cString;
//    public /*const*/std.string /*P*/ stdString;
//    public /*const*/StringRef /*P*/ stringRef;
//    public /*const*/SmallString/*P*/ smallString
//    public /*char*/byte character;
//    public /*uint*/int decUI;
//    public int decI;
//    public /*const*//*ulong*/long/*P*/ decUL;
//    public /*const*/long/*P*/ decL;
//    public /*const*//*ullong*/long/*P*/ decULL;
//    public /*const*//*llong*/long/*P*/ decLL;
//    public long/*uint64_t*/ uHex;
    //<editor-fold defaultstate="collapsed" desc="llvm::Twine::Child::Child">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 132,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 133,
     FQN = "llvm::Twine::Child::Child", NM = "_ZN4llvm5Twine5ChildC1Ev",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm5Twine5ChildC1Ev")
    //</editor-fold>
    public /*inline*/ Child() {
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::Twine::Child::Child">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 132,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 133,
     FQN = "llvm::Twine::Child::Child", NM = "_ZN4llvm5Twine5ChildC1ERKS1_",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm5Twine5ChildC1ERKS1_")
    //</editor-fold>
    public /*inline*/ Child(/*const*/Child /*&*/ $Prm0)/* throw()*/ {
      $assign($Prm0);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::Twine::Child::operator=">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 132,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 133,
     FQN = "llvm::Twine::Child::operator=", NM = "_ZN4llvm5Twine5ChildaSERKS1_",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm5Twine5ChildaSERKS1_")
    //</editor-fold>
    public /*inline*/ Child /*&*/ $assign(/*const*/Child /*&*/ $Prm0)/* throw()*/ {
      this.numVal = $Prm0.numVal;
      this.refVal = $Prm0.refVal;
      return /*Deref*/this;
    }

    public Twine getTwine() {
      return (Twine) refVal;
    }

    public void setTwine(Twine twine) {
      this.refVal = twine;
    }

    public char$ptr getCString() {
      return (char$ptr)refVal;
    }

    public void setCString(char$ptr cString) {
      refVal = cString;
    }

    public std.string getStdString() {
      return (string) refVal;
    }

    public void setStdString(string stdString) {
      refVal = stdString;
    }
        
    public StringRef getStringRef() {
      return (StringRef) refVal;
    }

    public void setStringRef(StringRef stringRef) {
      refVal = stringRef;
    }
    
    public SmallString getSmallString() {
      return (SmallString) refVal;
    }
    
    public void setSmallString(SmallString smallString) {
      refVal = smallString;
    }
    
    public byte getCharacter() {
      return (byte) numVal;
    }
    
    public void setCharacter(byte Val) {
      numVal = Val;
    }
    
    public /*uint*/int getDecUI() {
      return $long2uint(numVal);
    }

    public void setDecUI(/*uint*/int Val) {
      numVal = $uint2long(Val);
    }
    
    public int getDecI() {
      return (int) numVal;
    }

    public void setDecI(int Val) {
      numVal = Val;
    }
    
    public /*ulong*/long getDecUL() {
      return numVal;
    }
    
    public void setDecUL(/*ulong*/long Val) {
      numVal = Val;
    }

    public long getDecL() {
      return numVal;
    }
    
    public void setDecL(long Val) {
      numVal = Val;
    }

    public /*ullong*/long getDecULL() {
      return numVal;
    }
    
    public void setDecULL(/*ullong*/long Val) {
      numVal = Val;
    }

    public /*llong*/long getDecLL() {
      return numVal;
    }
    
    public void setDecLL(/*llong*/long Val) {
      numVal = Val;
    }

    public long/*uint64_t*/ getUHex() {
      return numVal;
    }

    public void setUHex(long/*uint64_t*/ Val) {
      numVal = Val;
    }
  };
  
  private static final class DummyChild extends Child {

    private DummyChild() {
    }

    @Override
    public Child $assign(Child $Prm0) {
      throw new UnsupportedOperationException("Dummy Child Can not be modified"); // NOI18N
    }

    @Override
    public void setUHex(long/*uint64_t*/ Val) {
      throw new UnsupportedOperationException("Dummy Child Can not be modified"); // NOI18N
    }

    @Override
    public void setDecLL(long Val) {
      throw new UnsupportedOperationException("Dummy Child Can not be modified"); // NOI18N
    }

    @Override
    public void setDecULL(long Val) {
      throw new UnsupportedOperationException("Dummy Child Can not be modified"); // NOI18N
    }

    @Override
    public void setDecL(long Val) {
      throw new UnsupportedOperationException("Dummy Child Can not be modified"); // NOI18N
    }

    @Override
    public void setDecUL(long Val) {
      throw new UnsupportedOperationException("Dummy Child Can not be modified"); // NOI18N
    }

    @Override
    public void setDecI(int Val) {
      throw new UnsupportedOperationException("Dummy Child Can not be modified"); // NOI18N
    }

    @Override
    public void setDecUI(/*uint*/int Val) {
      throw new UnsupportedOperationException("Dummy Child Can not be modified"); // NOI18N
    }

    @Override
    public void setCharacter(byte Val) {
      throw new UnsupportedOperationException("Dummy Child Can not be modified"); // NOI18N
    }

    @Override
    public void setStringRef(StringRef stringRef) {
      throw new UnsupportedOperationException("Dummy Child Can not be modified"); // NOI18N
    }

    @Override
    public void setStdString(string stdString) {
      throw new UnsupportedOperationException("Dummy Child Can not be modified"); // NOI18N
    }

    @Override
    public void setCString(char$ptr cString) {
      throw new UnsupportedOperationException("Dummy Child Can not be modified"); // NOI18N
    }
    
    @Override
    public void setTwine(Twine twine) {
      throw new UnsupportedOperationException("Dummy Child Can not be modified"); // NOI18N
    }
  };
  
  private static final Child DUMMY_CHILD;
  static {
    if (NativeTrace.isDebugMode()) {
      DUMMY_CHILD = new DummyChild();
    } else {
      // do not load extra class in release mode
      DUMMY_CHILD = new Child();
    }
  }
  
/*private:*/
  /// LHS - The prefix in the concatenation, which may be uninitialized for
  /// Null or Empty kinds.
  private final Child LHS;
  /// RHS - The suffix in the concatenation, which may be uninitialized for
  /// Null or Empty kinds.
  private final Child RHS;
  /// LHSKind - The NodeKind of the left hand side, \see getLHSKind().
  private final char LHSKind;
  /// RHSKind - The NodeKind of the left hand side, \see getLHSKind().
  private final char RHSKind;
/*private:*/
  /// Construct a nullary twine; the kind must be NullKind or EmptyKind.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::Twine">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 163,
   FQN = "llvm::Twine::Twine", NM = "_ZN4llvm5TwineC1ENS0_8NodeKindE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm5TwineC1ENS0_8NodeKindE")
  //</editor-fold>
  private /*explicit*/ Twine(boolean nodeKindFlag) {
    /* : LHS(), RHS(), LHSKind(Kind), RHSKind(EmptyKind)*/ 
    //START JInit
    this.LHS = DUMMY_CHILD;
    this.RHS = DUMMY_CHILD;
    this.LHSKind = NodeKind.NullKind;
    this.RHSKind = NodeKind.EmptyKind;
    //END JInit
    assert (isNullary()) : "Invalid kind!";
  }
  private static final Twine NullKindTwine = new Twine(true);
  
  /// Construct a binary twine.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::Twine">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 169,
   FQN = "llvm::Twine::Twine", NM = "_ZN4llvm5TwineC1ERKS0_S2_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm5TwineC1ERKS0_S2_")
  //</editor-fold>
  private /*explicit*/ Twine(/*const*/Twine /*&*/ _LHS, /*const*/Twine /*&*/ _RHS) {
    /* : LHS(), RHS(), LHSKind(TwineKind), RHSKind(TwineKind)*/ 
    //START JInit
    this.LHS = new Child();
    this.RHS = new Child();
    this.LHSKind = NodeKind.TwineKind;
    this.RHSKind = NodeKind.TwineKind;
    //END JInit
    LHS.setTwine(_LHS);
    RHS.setTwine(_RHS);
    assert (isValid()) : "Invalid twine!";
  }

  
  /// Construct a twine from explicit values.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::Twine">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 177,
   FQN = "llvm::Twine::Twine", NM = "_ZN4llvm5TwineC1ENS0_5ChildENS0_8NodeKindES1_S2_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm5TwineC1ENS0_5ChildENS0_8NodeKindES1_S2_")
  //</editor-fold>
  private /*explicit*/ Twine(Child _LHS, /*NodeKind*/char _LHSKind, Child _RHS, /*NodeKind*/char _RHSKind) {
    /* : LHS(_LHS), RHS(_RHS), LHSKind(_LHSKind), RHSKind(_RHSKind)*/ 
    //START JInit
    this.LHS = new Child(_LHS);
    this.RHS = new Child(_RHS);
    this.LHSKind = _LHSKind;
    this.RHSKind = _RHSKind;
    //END JInit
    assert (isValid()) : "Invalid twine!";
  }

  
  /// Check for the null twine.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::isNull">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 187,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 188,
   FQN = "llvm::Twine::isNull", NM = "_ZNK4llvm5Twine6isNullEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZNK4llvm5Twine6isNullEv")
  //</editor-fold>
  private boolean isNull() /*const*/ {
    return getLHSKind() == NodeKind.NullKind;
  }

  
   /// Check for the empty twine.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::isEmpty">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 192,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 193,
   FQN = "llvm::Twine::isEmpty", NM = "_ZNK4llvm5Twine7isEmptyEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZNK4llvm5Twine7isEmptyEv")
  //</editor-fold>
  private boolean isEmpty() /*const*/ {
    return getLHSKind() == NodeKind.EmptyKind;
  }

  
  /// Check if this is a nullary twine (null or empty).
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::isNullary">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 197,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 198,
   FQN = "llvm::Twine::isNullary", NM = "_ZNK4llvm5Twine9isNullaryEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZNK4llvm5Twine9isNullaryEv")
  //</editor-fold>
  private boolean isNullary() /*const*/ {
    return isNull() || isEmpty();
  }

  
  /// Check if this is a unary twine.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::isUnary">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 202,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 203,
   FQN = "llvm::Twine::isUnary", NM = "_ZNK4llvm5Twine7isUnaryEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZNK4llvm5Twine7isUnaryEv")
  //</editor-fold>
  private boolean isUnary() /*const*/ {
    return getRHSKind() == NodeKind.EmptyKind && !isNullary();
  }

  
  /// Check if this is a binary twine.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::isBinary">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 207,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 208,
   FQN = "llvm::Twine::isBinary", NM = "_ZNK4llvm5Twine8isBinaryEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZNK4llvm5Twine8isBinaryEv")
  //</editor-fold>
  private boolean isBinary() /*const*/ {
    return getLHSKind() != NodeKind.NullKind && getRHSKind() != NodeKind.EmptyKind;
  }

  
  /// Check if this is a valid twine (satisfying the invariants on
  /// order and number of arguments).
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::isValid">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 213,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 214,
   FQN = "llvm::Twine::isValid", NM = "_ZNK4llvm5Twine7isValidEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZNK4llvm5Twine7isValidEv")
  //</editor-fold>
  private boolean isValid() /*const*/ {
    // Nullary twines always have Empty on the RHS.
    if (isNullary() && getRHSKind() != NodeKind.EmptyKind) {
      return false;
    }
    
    // Null should never appear on the RHS.
    if (getRHSKind() == NodeKind.NullKind) {
      return false;
    }
    
    // The RHS cannot be non-empty if the LHS is empty.
    if (getRHSKind() != NodeKind.EmptyKind && getLHSKind() == NodeKind.EmptyKind) {
      return false;
    }
    
    // A twine child should always be binary.
    if (getLHSKind() == NodeKind.TwineKind && !LHS.getTwine().isBinary()) {
      return false;
    }
    if (getRHSKind() == NodeKind.TwineKind && !RHS.getTwine().isBinary()) {
      return false;
    }
    
    return true;
  }

  
  /// Get the NodeKind of the left-hand side.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::getLHSKind">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 238,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 239,
   FQN = "llvm::Twine::getLHSKind", NM = "_ZNK4llvm5Twine10getLHSKindEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZNK4llvm5Twine10getLHSKindEv")
  //</editor-fold>
  private /*NodeKind*/char getLHSKind() /*const*/ {
    return LHSKind;
  }

  
  /// Get the NodeKind of the right-hand side.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::getRHSKind">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 241,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 242,
   FQN = "llvm::Twine::getRHSKind", NM = "_ZNK4llvm5Twine10getRHSKindEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZNK4llvm5Twine10getRHSKindEv")
  //</editor-fold>
  private /*NodeKind*/char getRHSKind() /*const*/ {
    return RHSKind;
  }

  
  /// Print one child from a twine.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::printOneChild">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/lib/Support/Twine.cpp", line = 51,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Twine.cpp", old_line = 58,
   FQN="llvm::Twine::printOneChild", NM="_ZNK4llvm5Twine13printOneChildERNS_11raw_ostreamENS0_5ChildENS0_8NodeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZNK4llvm5Twine13printOneChildERNS_11raw_ostreamENS0_5ChildENS0_8NodeKindE")
  //</editor-fold>
  private void printOneChild(raw_ostream /*&*/ OS, Child Ptr, 
               /*Twine.NodeKind*/char Kind) /*const*/ {
    switch (Kind) {
     case NodeKind.NullKind:
      break;
     case NodeKind.EmptyKind:
      break;
     case NodeKind.TwineKind:
       Ptr.getTwine().print(OS);
      break;
     case NodeKind.CStringKind:
      OS.$out(Ptr.getCString());
      break;
     case NodeKind.StdStringKind:
      OS.$out(  $Deref(Ptr.getStdString()));
      break;
     case NodeKind.StringRefKind:
      OS.$out(/*NO_COPY*/$Deref(Ptr.getStringRef()));
      break;
     case NodeKind.SmallStringKind:
      OS.$out($Deref(Ptr.getSmallString()));
      break;
     case NodeKind.CharKind:
      OS.$out_char(Ptr.getCharacter());
      break;
     case NodeKind.DecUIKind:
      OS.$out_uint(Ptr.getDecUI());
      break;
     case NodeKind.DecIKind:
      OS.$out_int(Ptr.getDecI());
      break;
     case NodeKind.DecULKind:
      OS.$out_ulong(Ptr.getDecUL());
      break;
     case NodeKind.DecLKind:
      OS.$out_long(Ptr.getDecL());
      break;
     case NodeKind.DecULLKind:
      OS.$out_ullong(Ptr.getDecULL());
      break;
     case NodeKind.DecLLKind:
      OS.$out_llong(Ptr.getDecLL());
      break;
     case NodeKind.UHexKind:
      OS.write_hex(Ptr.getUHex());
      break;
     default:
      assert false : "Unexpected kind " + Kind;      
    }
  }

  
  /// Print the representation of one child from a twine.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::printOneChildRepr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/lib/Support/Twine.cpp", line = 98,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Twine.cpp", old_line = 102,
   FQN="llvm::Twine::printOneChildRepr", NM="_ZNK4llvm5Twine17printOneChildReprERNS_11raw_ostreamENS0_5ChildENS0_8NodeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZNK4llvm5Twine17printOneChildReprERNS_11raw_ostreamENS0_5ChildENS0_8NodeKindE")
  //</editor-fold>
  private void printOneChildRepr(raw_ostream /*&*/ OS, Child Ptr, 
                   /*Twine.NodeKind*/char Kind) /*const*/ {
    switch (Kind) {
     case NodeKind.NullKind:
      OS.$out(/*KEEP_STR*/"null");
      break;
     case NodeKind.EmptyKind:
      OS.$out(/*KEEP_STR*/"empty");
      break;
     case NodeKind.TwineKind:
      OS.$out(/*KEEP_STR*/"rope:");
      Ptr.getTwine().printRepr(OS);
      break;
     case NodeKind.CStringKind:
      OS.$out(/*KEEP_STR*/"cstring:\"").$out(Ptr.getCString()).$out(/*KEEP_STR*/$DBL_QUOTE);
      break;
     case NodeKind.StdStringKind:
      OS.$out(/*KEEP_STR*/"std::string:\"").$out(Ptr.getStdString()).$out(/*KEEP_STR*/$DBL_QUOTE);
      break;
     case NodeKind.StringRefKind:
      OS.$out(/*KEEP_STR*/"stringref:\"").$out(Ptr.getStringRef()).$out(/*KEEP_STR*/$DBL_QUOTE);
      break;
     case NodeKind.SmallStringKind:
      OS.$out(/*KEEP_STR*/"smallstring:\"").$out($Deref(Ptr.getSmallString())).$out(/*KEEP_STR*/$DBL_QUOTE);
      break;
     case NodeKind.CharKind:
      OS.$out(/*KEEP_STR*/"char:\"").$out_char(Ptr.getCharacter()).$out(/*KEEP_STR*/$DBL_QUOTE);
      break;
     case NodeKind.DecUIKind:
      OS.$out(/*KEEP_STR*/"decUI:\"").$out_uint(Ptr.getDecUI()).$out(/*KEEP_STR*/$DBL_QUOTE);
      break;
     case NodeKind.DecIKind:
      OS.$out(/*KEEP_STR*/"decI:\"").$out_int(Ptr.getDecI()).$out(/*KEEP_STR*/$DBL_QUOTE);
      break;
     case NodeKind.DecULKind:
      OS.$out(/*KEEP_STR*/"decUL:\"").$out_ulong(Ptr.getDecUL()).$out(/*KEEP_STR*/$DBL_QUOTE);
      break;
     case NodeKind.DecLKind:
      OS.$out(/*KEEP_STR*/"decL:\"").$out_long(Ptr.getDecL()).$out(/*KEEP_STR*/$DBL_QUOTE);
      break;
     case NodeKind.DecULLKind:
      OS.$out(/*KEEP_STR*/"decULL:\"").$out_ullong(Ptr.getDecULL()).$out(/*KEEP_STR*/$DBL_QUOTE);
      break;
     case NodeKind.DecLLKind:
      OS.$out(/*KEEP_STR*/"decLL:\"").$out_llong(Ptr.getDecLL()).$out(/*KEEP_STR*/$DBL_QUOTE);
      break;
     case NodeKind.UHexKind:
      OS.$out(/*KEEP_STR*/"uhex:\"").$out_hex(Ptr.getUHex()).$out(/*KEEP_STR*/$DBL_QUOTE);
      break;
     default:
      assert false : "Unexpected kind " + Kind;
    }
  }

/*public:*/
  
  /// Construct from an empty string.
  /*implicit*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::Twine">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 255,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 256,
   FQN = "llvm::Twine::Twine", NM = "_ZN4llvm5TwineC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm5TwineC1Ev")
  //</editor-fold>
  public Twine() {
    /* : LHS(), RHS(), LHSKind(EmptyKind), RHSKind(EmptyKind)*/ 
    //START JInit
    this.LHS = DUMMY_CHILD;
    this.RHS = DUMMY_CHILD;
    this.LHSKind = NodeKind.EmptyKind;
    this.RHSKind = NodeKind.EmptyKind;
    //END JInit
    assert (isValid()) : "Invalid twine!";
  }

  
  /// Construct from a C string.
  ///
  /// We take care here to optimize "" into the empty twine -- this will be
  /// optimized out for string constants. This allows Twine arguments have
  /// default "" values, without introducing unnecessary string constants.
  /*implicit*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::Twine">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 266,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 265,
   FQN = "llvm::Twine::Twine", NM = "_ZN4llvm5TwineC1EPKc",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm5TwineC1EPKc")
  //</editor-fold>
  public Twine(/*const*/char$ptr/*char P*/ Str) {
    /* : LHS(), RHS(), RHSKind(EmptyKind)*/ 
    //START JInit
    this.RHS = DUMMY_CHILD;
    this.RHSKind = NodeKind.EmptyKind;
    //END JInit
    if (Str.$at(0) != '\0') {
      this.LHS = new Child();
      LHS.setCString(Str);
      LHSKind = NodeKind.CStringKind;
    } else {
      this.LHS = DUMMY_CHILD;
      LHSKind = NodeKind.EmptyKind;
    }
    assert (isValid()) : "Invalid twine!";
  }
  
  public Twine(/*const*/char$iterator<?>/*char P*/ Str) {
    this(Str.star$ref().deref$ptr());
  }  

  public Twine(byte[] Str) {
    this(create_char$ptr(Str));
  }
  
  /// Construct from a SmallString.
  /*implicit*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::Twine">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 292,
   FQN="llvm::Twine::Twine", NM="_ZN4llvm5TwineC1ERKNS_15SmallVectorImplIcEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm5TwineC1ERKNS_15SmallVectorImplIcEE")
  //</editor-fold>
  public Twine(/*const*/SmallString/*&*/ Str) {
    /* : LHS(), RHS(), LHSKind(SmallStringKind), RHSKind(EmptyKind)*/ 
    //START JInit
    this.LHS = new Child();
    this.RHS = new Child();
    this.LHSKind = NodeKind.SmallStringKind;
    this.RHSKind = NodeKind.EmptyKind;
    //END JInit
    LHS.setSmallString(Str);// = /*AddrOf*/Str;
    assert (isValid()) : "Invalid twine!";
  }
  
  /// Construct from an std::string.
  /*implicit*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::Twine">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 278,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 277,
   FQN = "llvm::Twine::Twine", NM = "_ZN4llvm5TwineC1ERKSs",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm5TwineC1ERKSs")
  //</editor-fold>
  public Twine(/*const*/std.string /*&*/ Str) {
    /* : LHS(), RHS(), LHSKind(StdStringKind), RHSKind(EmptyKind)*/ 
    //START JInit
    this.LHS = new Child();
    this.RHS = DUMMY_CHILD;
    this.LHSKind = NodeKind.StdStringKind;
    this.RHSKind = NodeKind.EmptyKind;
    //END JInit
    LHS.setStdString(Str);// = /*AddrOf*/Str;
    assert (isValid()) : "Invalid twine!";
  }

  
  /// Construct from a StringRef.
  /*implicit*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::Twine">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 285,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 284,
   FQN = "llvm::Twine::Twine", NM = "_ZN4llvm5TwineC1ERKNS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm5TwineC1ERKNS_9StringRefE")
  //</editor-fold>
  public Twine(/*const*/StringRef /*&*/ Str) {
    /* : LHS(), RHS(), LHSKind(StringRefKind), RHSKind(EmptyKind)*/ 
    //START JInit
    this.LHS = new Child();
    this.RHS = DUMMY_CHILD;
    this.LHSKind = NodeKind.StringRefKind;
    this.RHSKind = NodeKind.EmptyKind;
    //END JInit
    LHS.setStringRef(Str);// = /*AddrOf*/Str;
    assert (isValid()) : "Invalid twine!";
  }

  public Twine(/*const*/String /*&*/ Str) {
    /* : LHS(), RHS(), LHSKind(StringRefKind), RHSKind(EmptyKind)*/ 
    //START JInit
    this(create_char$ptr(Str));
  }  
  
  // FIXME: Unfortunately, to make sure this is as efficient as possible we
  // need extra binary constructors from particular types. We can't rely on
  // the compiler to be smart enough to fold operator+()/concat() down to the
  // right thing. Yet.

  /// Construct as the concatenation of a C string and a StringRef.
  public Twine(char$ptr _LHS, StringRef _RHS)
    /*: LHSKind(CStringKind), RHSKind(StringRefKind)*/ {
    this.LHS = new Child();
    this.RHS = new Child();
    this.LHSKind = NodeKind.CStringKind;
    this.RHSKind = NodeKind.StringRefKind;      
    LHS.setCString(_LHS);
    RHS.setStringRef(_RHS);
    assert(isValid()) : "Invalid twine!";
  }
  
  public Twine(char$ptr _LHS, char$ptr _RHS)
    /*: LHSKind(CStringKind), RHSKind(StringRefKind)*/ {
    this.LHS = new Child();
    this.RHS = new Child();
    this.LHSKind = NodeKind.CStringKind;
    this.RHSKind = NodeKind.CStringKind;      
    LHS.setCString(_LHS);
    RHS.setCString(_RHS);
    assert(isValid()) : "Invalid twine!";
  }
  
  public Twine(String _LHS, char$ptr _RHS)
    /*: LHSKind(CStringKind), RHSKind(CStringKind)*/ {
    this(create_char$ptr(_LHS), _RHS);
  }  
  
  public Twine(char$ptr _LHS, String _RHS)
    /*: LHSKind(CStringKind), RHSKind(CStringKind)*/ {
    this(_LHS, create_char$ptr(_RHS));
  }  
  
  public Twine(String _LHS, StringRef _RHS)
    /*: LHSKind(CStringKind), RHSKind(StringRefKind)*/ {
    this(create_char$ptr(_LHS), _RHS);
  }  

  /// Construct as the concatenation of a StringRef and a C string.
  public Twine(StringRef _LHS, char$ptr _RHS)
    /*: LHSKind(StringRefKind), RHSKind(CStringKind)*/ {
    this.LHS = new Child();
    this.RHS = new Child();
    this.LHSKind = NodeKind.StringRefKind;
    this.RHSKind = NodeKind.CStringKind;            
    LHS.setStringRef(_LHS);
    RHS.setCString(_RHS);
    assert(isValid()) : "Invalid twine!";
  }    
  public Twine(StringRef _LHS, String _RHS)
    /*: LHSKind(StringRefKind), RHSKind(CStringKind)*/ {
    this(_LHS, create_char$ptr(_RHS));
  }  
  
  /// Construct from a char.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::Twine">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 299,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 291,
   FQN = "llvm::Twine::Twine", NM = "_ZN4llvm5TwineC1Ec",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm5TwineC1Ec")
  //</editor-fold>
  public /*explicit*/ Twine(JD$Char _dparam, /*char*/byte Val) {
    /* : LHS(), RHS(), LHSKind(CharKind), RHSKind(EmptyKind)*/ 
    //START JInit
    this.LHS = new Child();
    this.RHS = DUMMY_CHILD;
    this.LHSKind = NodeKind.CharKind;
    this.RHSKind = NodeKind.EmptyKind;
    //END JInit
    LHS.setCharacter(Val);
  }

  
  /// Construct from a signed char.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::Twine">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 305,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 297,
   FQN = "llvm::Twine::Twine", NM = "_ZN4llvm5TwineC1Ea",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm5TwineC1Ea")
  //</editor-fold>
  public /*explicit*/ Twine(JD$SChar _dparam, /*schar*/byte Val) {
    /* : LHS(), RHS(), LHSKind(CharKind), RHSKind(EmptyKind)*/ 
    //START JInit
    this.LHS = new Child();
    this.RHS = DUMMY_CHILD;
    this.LHSKind = NodeKind.CharKind;
    this.RHSKind = NodeKind.EmptyKind;
    //END JInit
    LHS.setCharacter((/*static_cast*//*char*/byte)(Val));
  }

  
  /// Construct from an unsigned char.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::Twine">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 311,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 303,
   FQN = "llvm::Twine::Twine", NM = "_ZN4llvm5TwineC1Eh",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm5TwineC1Eh")
  //</editor-fold>
  public /*explicit*/ Twine(JD$UChar _dparam, /*uchar*/short Val) {
    /* : LHS(), RHS(), LHSKind(CharKind), RHSKind(EmptyKind)*/ 
    //START JInit
    this.LHS = new Child();
    this.RHS = DUMMY_CHILD;
    this.LHSKind = NodeKind.CharKind;
    this.RHSKind = NodeKind.EmptyKind;
    //END JInit
    LHS.setCharacter((/*static_cast*//*char*/byte)(Val));
  }

  
  /// Construct a twine to print \p Val as an unsigned decimal integer.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::Twine">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 317,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 309,
   FQN = "llvm::Twine::Twine", NM = "_ZN4llvm5TwineC1Ej",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm5TwineC1Ej")
  //</editor-fold>
  public /*explicit*/ Twine(JD$UInt _dparam, /*uint*/int Val) {
    /* : LHS(), RHS(), LHSKind(DecUIKind), RHSKind(EmptyKind)*/ 
    //START JInit
    this.LHS = new Child();
    this.RHS = DUMMY_CHILD;
    this.LHSKind = NodeKind.DecUIKind;
    this.RHSKind = NodeKind.EmptyKind;
    //END JInit
    assert Val >= 0 : "forgot about unsigned conversion?";
    LHS.setDecUI(Val);
  }

  
  /// Construct a twine to print \p Val as a signed decimal integer.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::Twine">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 323,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 315,
   FQN = "llvm::Twine::Twine", NM = "_ZN4llvm5TwineC1Ei",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm5TwineC1Ei")
  //</editor-fold>
  public /*explicit*/ Twine(JD$Int _dparam, int Val) {
    /* : LHS(), RHS(), LHSKind(DecIKind), RHSKind(EmptyKind)*/ 
    //START JInit
    this.LHS = new Child();
    this.RHS = DUMMY_CHILD;
    this.LHSKind = NodeKind.DecIKind;
    this.RHSKind = NodeKind.EmptyKind;
    //END JInit
    LHS.setDecI(Val);
  }

  
  /// Construct a twine to print \p Val as an unsigned decimal integer.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::Twine">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 329,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 321,
   FQN = "llvm::Twine::Twine", NM = "_ZN4llvm5TwineC1ERKm",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm5TwineC1ERKm")
  //</editor-fold>
  public /*explicit*/ Twine(JD$ULong _dparam, /*const*//*ulong*/long/*&*/ Val) {
    /* : LHS(), RHS(), LHSKind(DecULKind), RHSKind(EmptyKind)*/ 
    //START JInit
    this.LHS = new Child();
    this.RHS = DUMMY_CHILD;
    this.LHSKind = NodeKind.DecULKind;
    this.RHSKind = NodeKind.EmptyKind;
    //END JInit
    LHS.setDecUL(Val);
  }

  
  /// Construct a twine to print \p Val as a signed decimal integer.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::Twine">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 335,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 327,
   FQN = "llvm::Twine::Twine", NM = "_ZN4llvm5TwineC1ERKl",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm5TwineC1ERKl")
  //</editor-fold>
  public /*explicit*/ Twine(JD$Long _dparam, /*const*/long/*&*/ Val) {
    /* : LHS(), RHS(), LHSKind(DecLKind), RHSKind(EmptyKind)*/ 
    //START JInit
    this.LHS = new Child();
    this.RHS = DUMMY_CHILD;
    this.LHSKind = NodeKind.DecLKind;
    this.RHSKind = NodeKind.EmptyKind;
    //END JInit
    LHS.setDecL(Val);
  }

  
  /// Construct a twine to print \p Val as an unsigned decimal integer.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::Twine">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 341,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 333,
   FQN = "llvm::Twine::Twine", NM = "_ZN4llvm5TwineC1ERKy",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm5TwineC1ERKy")
  //</editor-fold>
  public /*explicit*/ Twine(JD$ULLong _dparam, /*const*/long/*ullong &*/ Val) {
    /* : LHS(), RHS(), LHSKind(DecULLKind), RHSKind(EmptyKind)*/ 
    //START JInit
    this.LHS = new Child();
    this.RHS = DUMMY_CHILD;
    this.LHSKind = NodeKind.DecULLKind;
    this.RHSKind = NodeKind.EmptyKind;
    //END JInit
    LHS.setDecULL(Val);
  }

  
  /// Construct a twine to print \p Val as a signed decimal integer.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::Twine">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 347,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 339,
   FQN = "llvm::Twine::Twine", NM = "_ZN4llvm5TwineC1ERKx",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm5TwineC1ERKx")
  //</editor-fold>
  public /*explicit*/ Twine(JD$LLong _dparam, /*const*/long/*llong &*/ Val) {
    /* : LHS(), RHS(), LHSKind(DecLLKind), RHSKind(EmptyKind)*/ 
    //START JInit
    this.LHS = new Child();
    this.RHS = DUMMY_CHILD;
    this.LHSKind = NodeKind.DecLLKind;
    this.RHSKind = NodeKind.EmptyKind;
    //END JInit
    LHS.setDecLL(Val);
  }
  
  /// Create a 'null' string, which is an empty string that always
  /// concatenates to form another empty string.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::createNull">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 375,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 367,
   FQN = "llvm::Twine::createNull", NM = "_ZN4llvm5Twine10createNullEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm5Twine10createNullEv")
  //</editor-fold>
  public static Twine createNull() {
    return Twine.NullKindTwine;
  }

  
  // Construct a twine to print \p Val as an unsigned hexadecimal integer.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::utohexstr">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 384,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 376,
   FQN = "llvm::Twine::utohexstr", NM = "_ZN4llvm5Twine9utohexstrERKy",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm5Twine9utohexstrERKy")
  //</editor-fold>
  public static Twine utohexstr(/*const*/long/*uint64_t*//*&*/ Val) {
    Child LHS/*J*/= new Child(), RHS/*J*/= DUMMY_CHILD;
    LHS.setUHex(Val);// = /*AddrOf*/Val;
//    RHS.setTwine(null);
    return new Twine(LHS, NodeKind.UHexKind, RHS, NodeKind.EmptyKind);
  }

  
  /// Check if this twine is trivially empty; a false return value does not
  /// necessarily mean the twine is empty.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::isTriviallyEmpty">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 397,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 389,
   FQN = "llvm::Twine::isTriviallyEmpty", NM = "_ZNK4llvm5Twine16isTriviallyEmptyEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZNK4llvm5Twine16isTriviallyEmptyEv")
  //</editor-fold>
  public boolean isTriviallyEmpty() /*const*/ {
    return isNullary();
  }

  
  /// Return true if this twine can be dynamically accessed as a single
  /// StringRef value with getSingleStringRef().
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::isSingleStringRef">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 403,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 395,
   FQN="llvm::Twine::isSingleStringRef", NM="_ZNK4llvm5Twine17isSingleStringRefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZNK4llvm5Twine17isSingleStringRefEv")
  //</editor-fold>
  public boolean isSingleStringRef() /*const*/ {
    if (getRHSKind() != NodeKind.EmptyKind) {
      return false;
    }
    switch (getLHSKind()) {
     case NodeKind.EmptyKind:
     case NodeKind.CStringKind:
     case NodeKind.StdStringKind:
     case NodeKind.StringRefKind:
     case NodeKind.SmallStringKind:
      return true;
     default:
      return false;
    }
  }

  
  /// @}
  /// @name String Operations
  /// @{
  
  /// @name Twine Inline Implementations
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::concat">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 485,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 471,
   FQN = "llvm::Twine::concat", NM = "_ZNK4llvm5Twine6concatERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZNK4llvm5Twine6concatERKS0_")
  //</editor-fold>
  public /*inline*/ Twine concat(/*const*/Twine /*&*/ Suffix) /*const*/ {
    // Concatenation with null is null.
    if (isNull() || Suffix.isNull()) {
      return Twine.NullKindTwine;
    }
    
    // Concatenation with empty yields the other side.
    if (isEmpty()) {
      return Suffix;
    }
    if (Suffix.isEmpty()) {
      return /*Deref*/this;
    }
    
    // Otherwise we need to create a new node, taking care to fold in unary
    // twines.
    Child NewLHS/*J*/= new Child(), NewRHS/*J*/= new Child();
    NewLHS.setTwine(this);
    NewRHS.setTwine(Suffix);
    /*NodeKind*/char NewLHSKind = NodeKind.TwineKind, NewRHSKind = NodeKind.TwineKind;
    if (isUnary()) {
      NewLHS.$assign(LHS);
      NewLHSKind = getLHSKind();
    }
    if (Suffix.isUnary()) {
      NewRHS.$assign(Suffix.LHS);
      NewRHSKind = Suffix.getLHSKind();
    }
    
    return new Twine(NewLHS, NewLHSKind, NewRHS, NewRHSKind);
  }

  
  /// Return the twine contents as a std::string.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::str">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Twine.cpp", line = 16,
   FQN = "llvm::Twine::str", NM = "_ZNK4llvm5Twine3strEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZNK4llvm5Twine3strEv")
  //</editor-fold>
  public std.string str() /*const*/ {
    // If we're storing only a std::string, just return it.
    if (LHSKind == NodeKind.StdStringKind && RHSKind == NodeKind.EmptyKind) {
      return   $Deref($Deref(LHS.getStdString()));
    }
    
    // Otherwise, flatten and copy the contents first.
    SmallString/*256*/ Vec/*J*/= new SmallString(256);
    return toStringRef(Vec).str();
  }

  
  /// Append the concatenated string into the given SmallString or SmallVector.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::toVector">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Twine.cpp", line = 26,
   FQN = "llvm::Twine::toVector", NM = "_ZNK4llvm5Twine8toVectorERNS_15SmallVectorImplIcEE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZNK4llvm5Twine8toVectorERNS_15SmallVectorImplIcEE")
  //</editor-fold>
  public void toVector(SmallString/*&*/ Out) /*const*/ {
    raw_svector_ostream OS = null;
    try {
      OS/*J*/= new raw_svector_ostream(Out);
      print(OS);
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

  
  /// This returns the twine as a single StringRef.  This method is only valid
  /// if isSingleStringRef() is true.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::getSingleStringRef">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 436,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 428,
   FQN="llvm::Twine::getSingleStringRef", NM="_ZNK4llvm5Twine18getSingleStringRefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZNK4llvm5Twine18getSingleStringRefEv")
  //</editor-fold>
  public StringRef getSingleStringRef() /*const*/ {
    assert (isSingleStringRef()) : "This cannot be had as a single stringref!";
    switch (getLHSKind()) {
     default:
      /*::*/llvm.llvm_unreachable_internal("Out of sync with isSingleStringRef");
     case NodeKind.EmptyKind:
      return StringRef.R$EMPTY;
     case NodeKind.CStringKind:
      return new StringRef(LHS.getCString());
     case NodeKind.StdStringKind:
      return new StringRef(  $Deref($Deref(LHS.getStdString())));
     case NodeKind.StringRefKind:
      return   $Deref($Deref(LHS.getStringRef()));
     case NodeKind.SmallStringKind:
      return LHS.getSmallString().$StringRef();      
    }
  }

  
  /// toStringRef - This returns the twine as a single StringRef if it can be
  /// represented as such. Otherwise the twine is written into the given
  /// SmallVector and a StringRef to the SmallVector's data is returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::toStringRef">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 452,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Twine.cpp", old_line = 31,
   FQN = "llvm::Twine::toStringRef", NM = "_ZNK4llvm5Twine11toStringRefERNS_15SmallVectorImplIcEE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZNK4llvm5Twine11toStringRefERNS_15SmallVectorImplIcEE")
  //</editor-fold>
  public StringRef toStringRef(SmallString/*&*/ Out) /*const*/ {
    if (isSingleStringRef()) {
      return getSingleStringRef();
    }
    toVector(Out);
    return new StringRef(Out.data(), Out.size());
  }
  public StringRef toStringRef(SmallString/*&*/ Out, StringRef OutStrRef) /*const*/ {
    if (isSingleStringRef()) {
      return getSingleStringRef();
    }
    toVector(Out);
    return OutStrRef.$assign(Out.data(), Out.size());
  }

  
  /// This returns the twine as a single null terminated StringRef if it
  /// can be represented as such. Otherwise the twine is written into the
  /// given SmallVector and a StringRef to the SmallVector's data is returned.
  ///
  /// The returned StringRef's size does not include the null terminator.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::toNullTerminatedStringRef">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Twine.cpp", line = 31,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Twine.cpp", old_line = 38,
   FQN = "llvm::Twine::toNullTerminatedStringRef", NM = "_ZNK4llvm5Twine25toNullTerminatedStringRefERNS_15SmallVectorImplIcEE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZNK4llvm5Twine25toNullTerminatedStringRefERNS_15SmallVectorImplIcEE")
  //</editor-fold>
  public StringRef toNullTerminatedStringRef(SmallString/*&*/ Out) /*const*/ {
    if (isUnary()) {
      switch (getLHSKind()) {
       case NodeKind.CStringKind:
        // Already null terminated, yay!
        return new StringRef(LHS.getCString());
       case NodeKind.StdStringKind:
        {
          /*const*/std.string /*P*/ str = LHS.getStdString();
          return new StringRef(str.c_str(), str.size());
        }
       default:
        break;
      }
    }
    toVector(Out);
    Out.push_back((byte) 0);
    Out.pop_back();
    return new StringRef(Out.data(), Out.size());
  }

  
  /// Write the concatenated string represented by this twine to the
  /// stream \p OS.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::print">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Twine.cpp", line = 151,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Twine.cpp", old_line = 152,
   FQN = "llvm::Twine::print", NM = "_ZNK4llvm5Twine5printERNS_11raw_ostreamE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZNK4llvm5Twine5printERNS_11raw_ostreamE")
  //</editor-fold>
  public void print(raw_ostream /*&*/ OS) /*const*/ {
    printOneChild(OS, LHS, getLHSKind());
    printOneChild(OS, RHS, getRHSKind());
  }

  
  /// Dump the concatenated string represented by this twine to stderr.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::dump">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Twine.cpp", line = 164,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Twine.cpp", old_line = 165,
   FQN = "llvm::Twine::dump", NM = "_ZNK4llvm5Twine4dumpEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZNK4llvm5Twine4dumpEv")
  //</editor-fold>
  public void dump() /*const*/ {
    print(dbgs());
  }

  
  /// Write the representation of this twine to the stream \p OS.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::printRepr">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Twine.cpp", line = 156,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Twine.cpp", old_line = 157,
   FQN = "llvm::Twine::printRepr", NM = "_ZNK4llvm5Twine9printReprERNS_11raw_ostreamE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZNK4llvm5Twine9printReprERNS_11raw_ostreamE")
  //</editor-fold>
  public void printRepr(raw_ostream /*&*/ OS) /*const*/ {
    OS.$out("(Twine ");
    printOneChildRepr(OS, LHS, getLHSKind());
    OS.$out(" ");
    printOneChildRepr(OS, RHS, getRHSKind());
    OS.$out(")");
  }

  
  /// Dump the representation of this twine to stderr.
  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::dumpRepr">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/Twine.cpp", line = 168,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Twine.cpp", old_line = 169,
   FQN = "llvm::Twine::dumpRepr", NM = "_ZNK4llvm5Twine8dumpReprEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZNK4llvm5Twine8dumpReprEv")
  //</editor-fold>
  public void dumpRepr() /*const*/ {
    printRepr(dbgs());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Twine::Twine">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 259,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", old_line = 81,
   FQN = "llvm::Twine::Twine", NM = "_ZN4llvm5TwineC1ERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvm5TwineC1ERKS0_")
  //</editor-fold>
  public /*inline*/ Twine(/*const*/Twine /*&*/ $Prm0)/* throw()*/ {
    /* : LHS(.LHS), RHS(.RHS), LHSKind(.LHSKind), RHSKind(.RHSKind)*/ 
    //START JInit
    this.LHS = new Child($Prm0.LHS);
    this.RHS = new Child($Prm0.RHS);
    this.LHSKind = $Prm0.LHSKind;
    this.RHSKind = $Prm0.RHSKind;
    //END JInit
  }

  @Override
  public Twine $assign(Twine value) {
    if (true) throw new UnsupportedOperationException();
//    this.LHS.$assign(value.LHS);
//    this.LHSKind = value.LHSKind;
//    this.RHS.$assign(value.RHS);
//    this.RHSKind = value.RHSKind;
    return this;
  }

  @Override
  public Twine clone() {
    return new Twine(this);
  }

  @Override
  public boolean $noteq(Twine other) {
    return !$eq(other);
  }

  @Override
  public boolean $eq(Twine other) {
    if (this.LHSKind != other.LHSKind) {
      return false;
    }
    if (this.RHSKind != other.RHSKind) {
      return false;
    }
    if (!Objects.equals(this.LHS, other.LHS)) {
      return false;
    }
    if (!Objects.equals(this.RHS, other.RHS)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Twine{[" + toJavaString() + "]:" + getKindName(getLHSKind()) + "|" + getKindName(getRHSKind()) + "}";
  }

  public String toJavaString() {
    return str().toJavaString();
  }
  
  private static String getKindName(/*NodeKind*/char kind) {
    switch (kind) {
      case NodeKind.NullKind:
        return "NullKind";
      case NodeKind.EmptyKind:
        return "EmptyKind";
      case NodeKind.TwineKind:
        return "TwineKind";
      case NodeKind.CStringKind:
        return "CStringKind";
      case NodeKind.StdStringKind:
        return "StdStringKind";
      case NodeKind.StringRefKind:
        return "StringRefKind";
      case NodeKind.SmallStringKind:
        return "SmallStringKind";
      case NodeKind.CharKind:
        return "CharKind";
      case NodeKind.DecUIKind:
        return "DecUIKind";
      case NodeKind.DecIKind:
        return "DecIKind";
      case NodeKind.DecULKind:
        return "DecULKind";
      case NodeKind.DecLKind:
        return "DecLKind";
      case NodeKind.DecULLKind:
        return "DecULLKind";
      case NodeKind.DecLLKind:
        return "DecLLKind";
      case NodeKind.UHexKind:
        return "UHexKind";
      default:
        llvm_unreachable_internal("Unknown " + $ushort2uint(kind));
        return "Unknown " + $ushort2uint(kind);
    }
  }
}
