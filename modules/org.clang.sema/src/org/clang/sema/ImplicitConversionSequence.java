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

package org.clang.sema;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.clang.ast.*;
;
import org.clang.basic.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;


/// ImplicitConversionSequence - Represents an implicit conversion
/// sequence, which may be a standard conversion sequence
/// (C++ 13.3.3.1.1), user-defined conversion sequence (C++ 13.3.3.1.2),
/// or an ellipsis conversion sequence (C++ 13.3.3.1.3).
//<editor-fold defaultstate="collapsed" desc="clang::ImplicitConversionSequence">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 376,
 FQN="clang::ImplicitConversionSequence", NM="_ZN5clang26ImplicitConversionSequenceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang26ImplicitConversionSequenceE")
//</editor-fold>
public class ImplicitConversionSequence implements Destructors.ClassWithDestructor {
/*public:*/
  /// Kind - The kind of implicit conversion sequence. BadConversion
  /// specifies that there is no conversion from the source type to
  /// the target type.  AmbiguousConversion represents the unique
  /// ambiguous conversion (C++0x [over.best.ics]p10).
  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitConversionSequence::Kind">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*added Uninitialized*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 382,
   FQN="clang::ImplicitConversionSequence::Kind", NM="_ZN5clang26ImplicitConversionSequence4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang26ImplicitConversionSequence4KindE")
  //</editor-fold>
  public enum Kind implements Native.ComparableLower {
    StandardConversion(0),
    UserDefinedConversion(StandardConversion.getValue() + 1),
    AmbiguousConversion(UserDefinedConversion.getValue() + 1),
    EllipsisConversion(AmbiguousConversion.getValue() + 1),
    BadConversion(EllipsisConversion.getValue() + 1),
    Uninitialized(BadConversion.getValue() + 1); // JAVA: ADDED, must be the same as Uninitialized below

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Kind valueOf(int val) {
      Kind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Kind[] VALUES;
      private static final Kind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Kind kind : Kind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Kind[min < 0 ? (1-min) : 0];
        VALUES = new Kind[max >= 0 ? (1+max) : 0];
        for (Kind kind : Kind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Kind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Kind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Kind)obj).value);}
    //</editor-fold>
  };
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitConversionSequence::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 391,
   FQN="clang::ImplicitConversionSequence::(anonymous)", NM="_ZN5clang26ImplicitConversionSequenceE_Unnamed_enum1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang26ImplicitConversionSequenceE_Unnamed_enum1")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int Uninitialized = Kind.BadConversion.getValue() + 1;
  /*}*/;
  
  /// ConversionKind - The kind of implicit conversion sequence.
  private /*uint*/int ConversionKind /*: 30*/;
  
  /// \brief Whether the target is really a std::initializer_list, and the
  /// sequence only represents the worst element conversion.
  private /*JBIT unsigned int*/ boolean StdInitializerListElement /*: 1*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitConversionSequence::setKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 402,
   FQN="clang::ImplicitConversionSequence::setKind", NM="_ZN5clang26ImplicitConversionSequence7setKindENS0_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang26ImplicitConversionSequence7setKindENS0_4KindE")
  //</editor-fold>
  private void setKind(Kind K) {
    destruct();
    ConversionKind = K.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitConversionSequence::destruct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 407,
   FQN="clang::ImplicitConversionSequence::destruct", NM="_ZN5clang26ImplicitConversionSequence8destructEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang26ImplicitConversionSequence8destructEv")
  //</editor-fold>
  private void destruct() {
    if (ConversionKind == $int2uint_30bits(Kind.AmbiguousConversion.getValue())) {
      Unnamed_field2.Ambiguous.destruct();
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitConversionSequence::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 412,
   FQN="clang::ImplicitConversionSequence::(anonymous)", NM="_ZN5clang26ImplicitConversionSequenceE_Unnamed_union1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang26ImplicitConversionSequenceE_Unnamed_union1")
  //</editor-fold>
  public static class/*union*/ Unnamed_union1 {
    /// When ConversionKind == StandardConversion, provides the
    /// details of the standard conversion sequence.
    public final StandardConversionSequence Standard = new StandardConversionSequence();
    
    /// When ConversionKind == UserDefinedConversion, provides the
    /// details of the user-defined conversion sequence.
    public final UserDefinedConversionSequence UserDefined = new UserDefinedConversionSequence();
    
    /// When ConversionKind == AmbiguousConversion, provides the
    /// details of the ambiguous conversion.
    public final AmbiguousConversionSequence Ambiguous = new AmbiguousConversionSequence();
    
    /// When ConversionKind == BadConversion, provides the details
    /// of the bad conversion.
    public final BadConversionSequence Bad = new BadConversionSequence();
    
    @Override public String toString() {
      return "" + "Standard=" + Standard // NOI18N
                + ", UserDefined=" + UserDefined // NOI18N
                + ", Ambiguous=" + Ambiguous // NOI18N
                + ", Bad=" + Bad; // NOI18N
    }
  };
  public final Unnamed_union1 Unnamed_field2 = new Unnamed_union1();
  
  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitConversionSequence::ImplicitConversionSequence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 430,
   FQN="clang::ImplicitConversionSequence::ImplicitConversionSequence", NM="_ZN5clang26ImplicitConversionSequenceC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang26ImplicitConversionSequenceC1Ev")
  //</editor-fold>
  public ImplicitConversionSequence() {
    // : ConversionKind(Uninitialized), StdInitializerListElement(false) 
    //START JInit
    this.ConversionKind = Uninitialized;
    this.StdInitializerListElement = false;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitConversionSequence::~ImplicitConversionSequence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 433,
   FQN="clang::ImplicitConversionSequence::~ImplicitConversionSequence", NM="_ZN5clang26ImplicitConversionSequenceD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang26ImplicitConversionSequenceD0Ev")
  //</editor-fold>
  public void $destroy() {
    destruct();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitConversionSequence::ImplicitConversionSequence">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*moved code into $assign*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 436,
   FQN="clang::ImplicitConversionSequence::ImplicitConversionSequence", NM="_ZN5clang26ImplicitConversionSequenceC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang26ImplicitConversionSequenceC1ERKS0_")
  //</editor-fold>
  public ImplicitConversionSequence(final /*const*/ ImplicitConversionSequence /*&*/ Other) {
    // : ConversionKind(Other.ConversionKind), StdInitializerListElement(Other.StdInitializerListElement) 
    //START JInit
    $assign(Other); // Moved code into $assign
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitConversionSequence::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*moved code from ctr to resolve new (this) ... */,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 450,
   FQN="clang::ImplicitConversionSequence::operator=", NM="_ZN5clang26ImplicitConversionSequenceaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang26ImplicitConversionSequenceaSERKS0_")
  //</editor-fold>
  public ImplicitConversionSequence /*&*/ $assign(final /*const*/ ImplicitConversionSequence /*&*/ Other) {
    destruct();
    // JAVA: /*FIXME:NEW_EXPR*/this = /*new (this)*/ new ImplicitConversionSequence(Other);
    //START JInit
    this.ConversionKind = Other.ConversionKind;
    this.StdInitializerListElement = Other.StdInitializerListElement;
    //END JInit
    switch (Kind.valueOf(ConversionKind)) {
     case Uninitialized:
      break;
     case StandardConversion:
      Unnamed_field2.Standard.$assign(Other.Unnamed_field2.Standard);
      break;
     case UserDefinedConversion:
      Unnamed_field2.UserDefined.$assign(Other.Unnamed_field2.UserDefined);
      break;
     case AmbiguousConversion:
      Unnamed_field2.Ambiguous.copyFrom(Other.Unnamed_field2.Ambiguous);
      break;
     case EllipsisConversion:
      break;
     case BadConversion:
      Unnamed_field2.Bad.$assign(Other.Unnamed_field2.Bad);
      break;
    }
    return this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitConversionSequence::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 457,
   FQN="clang::ImplicitConversionSequence::getKind", NM="_ZNK5clang26ImplicitConversionSequence7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang26ImplicitConversionSequence7getKindEv")
  //</editor-fold>
  public Kind getKind() /*const*/ {
    assert (isInitialized()) : "querying uninitialized conversion";
    return Kind.valueOf(ConversionKind);
  }

  
  /// \brief Return a ranking of the implicit conversion sequence
  /// kind, where smaller ranks represent better conversion
  /// sequences.
  ///
  /// In particular, this routine gives user-defined conversion
  /// sequences and ambiguous conversion sequences the same rank,
  /// per C++ [over.best.ics]p10.
  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitConversionSequence::getKindRank">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 469,
   FQN="clang::ImplicitConversionSequence::getKindRank", NM="_ZNK5clang26ImplicitConversionSequence11getKindRankEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang26ImplicitConversionSequence11getKindRankEv")
  //</editor-fold>
  public /*uint*/int getKindRank() /*const*/ {
    switch (getKind()) {
     case StandardConversion:
      return 0;
     case UserDefinedConversion:
     case AmbiguousConversion:
      return 1;
     case EllipsisConversion:
      return 2;
     case BadConversion:
      return 3;
    }
    throw new llvm_unreachable("Invalid ImplicitConversionSequence::Kind!");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitConversionSequence::isBad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 488,
   FQN="clang::ImplicitConversionSequence::isBad", NM="_ZNK5clang26ImplicitConversionSequence5isBadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang26ImplicitConversionSequence5isBadEv")
  //</editor-fold>
  public boolean isBad() /*const*/ {
    return getKind() == Kind.BadConversion;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitConversionSequence::isStandard">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 489,
   FQN="clang::ImplicitConversionSequence::isStandard", NM="_ZNK5clang26ImplicitConversionSequence10isStandardEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang26ImplicitConversionSequence10isStandardEv")
  //</editor-fold>
  public boolean isStandard() /*const*/ {
    return getKind() == Kind.StandardConversion;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitConversionSequence::isEllipsis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 490,
   FQN="clang::ImplicitConversionSequence::isEllipsis", NM="_ZNK5clang26ImplicitConversionSequence10isEllipsisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang26ImplicitConversionSequence10isEllipsisEv")
  //</editor-fold>
  public boolean isEllipsis() /*const*/ {
    return getKind() == Kind.EllipsisConversion;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitConversionSequence::isAmbiguous">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 491,
   FQN="clang::ImplicitConversionSequence::isAmbiguous", NM="_ZNK5clang26ImplicitConversionSequence11isAmbiguousEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang26ImplicitConversionSequence11isAmbiguousEv")
  //</editor-fold>
  public boolean isAmbiguous() /*const*/ {
    return getKind() == Kind.AmbiguousConversion;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitConversionSequence::isUserDefined">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 492,
   FQN="clang::ImplicitConversionSequence::isUserDefined", NM="_ZNK5clang26ImplicitConversionSequence13isUserDefinedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang26ImplicitConversionSequence13isUserDefinedEv")
  //</editor-fold>
  public boolean isUserDefined() /*const*/ {
    return getKind() == Kind.UserDefinedConversion;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitConversionSequence::isFailure">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 493,
   FQN="clang::ImplicitConversionSequence::isFailure", NM="_ZNK5clang26ImplicitConversionSequence9isFailureEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang26ImplicitConversionSequence9isFailureEv")
  //</editor-fold>
  public boolean isFailure() /*const*/ {
    return isBad() || isAmbiguous();
  }

  
  /// Determines whether this conversion sequence has been
  /// initialized.  Most operations should never need to query
  /// uninitialized conversions and should assert as above.
  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitConversionSequence::isInitialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 498,
   FQN="clang::ImplicitConversionSequence::isInitialized", NM="_ZNK5clang26ImplicitConversionSequence13isInitializedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang26ImplicitConversionSequence13isInitializedEv")
  //</editor-fold>
  public boolean isInitialized() /*const*/ {
    return ConversionKind != $int2uint_30bits(Uninitialized);
  }

  
  /// Sets this sequence as a bad conversion for an explicit argument.
  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitConversionSequence::setBad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 501,
   FQN="clang::ImplicitConversionSequence::setBad", NM="_ZN5clang26ImplicitConversionSequence6setBadENS_21BadConversionSequence11FailureKindEPNS_4ExprENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang26ImplicitConversionSequence6setBadENS_21BadConversionSequence11FailureKindEPNS_4ExprENS_8QualTypeE")
  //</editor-fold>
  public void setBad(BadConversionSequence.FailureKind Failure, 
        Expr /*P*/ FromExpr, QualType ToType) {
    setKind(Kind.BadConversion);
    Unnamed_field2.Bad.init(Failure, FromExpr, new QualType(ToType));
  }

  
  /// Sets this sequence as a bad conversion for an implicit argument.
  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitConversionSequence::setBad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 508,
   FQN="clang::ImplicitConversionSequence::setBad", NM="_ZN5clang26ImplicitConversionSequence6setBadENS_21BadConversionSequence11FailureKindENS_8QualTypeES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang26ImplicitConversionSequence6setBadENS_21BadConversionSequence11FailureKindENS_8QualTypeES3_")
  //</editor-fold>
  public void setBad(BadConversionSequence.FailureKind Failure, 
        QualType FromType, QualType ToType) {
    setKind(Kind.BadConversion);
    Unnamed_field2.Bad.init(Failure, new QualType(FromType), new QualType(ToType));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitConversionSequence::setStandard">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 514,
   FQN="clang::ImplicitConversionSequence::setStandard", NM="_ZN5clang26ImplicitConversionSequence11setStandardEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang26ImplicitConversionSequence11setStandardEv")
  //</editor-fold>
  public void setStandard() {
    setKind(Kind.StandardConversion);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitConversionSequence::setEllipsis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 515,
   FQN="clang::ImplicitConversionSequence::setEllipsis", NM="_ZN5clang26ImplicitConversionSequence11setEllipsisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang26ImplicitConversionSequence11setEllipsisEv")
  //</editor-fold>
  public void setEllipsis() {
    setKind(Kind.EllipsisConversion);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitConversionSequence::setUserDefined">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 516,
   FQN="clang::ImplicitConversionSequence::setUserDefined", NM="_ZN5clang26ImplicitConversionSequence14setUserDefinedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang26ImplicitConversionSequence14setUserDefinedEv")
  //</editor-fold>
  public void setUserDefined() {
    setKind(Kind.UserDefinedConversion);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitConversionSequence::setAmbiguous">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 517,
   FQN="clang::ImplicitConversionSequence::setAmbiguous", NM="_ZN5clang26ImplicitConversionSequence12setAmbiguousEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang26ImplicitConversionSequence12setAmbiguousEv")
  //</editor-fold>
  public void setAmbiguous() {
    if (ConversionKind == $int2uint_30bits(Kind.AmbiguousConversion.getValue())) {
      return;
    }
    ConversionKind = Kind.AmbiguousConversion.getValue();
    Unnamed_field2.Ambiguous.construct();
  }

  
  /// \brief Whether the target is really a std::initializer_list, and the
  /// sequence only represents the worst element conversion.
  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitConversionSequence::isStdInitializerListElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 525,
   FQN="clang::ImplicitConversionSequence::isStdInitializerListElement", NM="_ZNK5clang26ImplicitConversionSequence27isStdInitializerListElementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang26ImplicitConversionSequence27isStdInitializerListElementEv")
  //</editor-fold>
  public boolean isStdInitializerListElement() /*const*/ {
    return StdInitializerListElement;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitConversionSequence::setStdInitializerListElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 529,
   FQN="clang::ImplicitConversionSequence::setStdInitializerListElement", NM="_ZN5clang26ImplicitConversionSequence28setStdInitializerListElementEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang26ImplicitConversionSequence28setStdInitializerListElementEb")
  //</editor-fold>
  public void setStdInitializerListElement() {
    setStdInitializerListElement(true);
  }
  public void setStdInitializerListElement(boolean V/*= true*/) {
    StdInitializerListElement = V;
  }

  
  // The result of a comparison between implicit conversion
  // sequences. Use Sema::CompareImplicitConversionSequences to
  // actually perform the comparison.
  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitConversionSequence::CompareKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 536,
   FQN="clang::ImplicitConversionSequence::CompareKind", NM="_ZN5clang26ImplicitConversionSequence11CompareKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang26ImplicitConversionSequence11CompareKindE")
  //</editor-fold>
  public enum CompareKind implements Native.ComparableLower {
    Better(-1),
    Indistinguishable(0),
    Worse(1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static CompareKind valueOf(int val) {
      CompareKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final CompareKind[] VALUES;
      private static final CompareKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (CompareKind kind : CompareKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new CompareKind[min < 0 ? (1-min) : 0];
        VALUES = new CompareKind[max >= 0 ? (1+max) : 0];
        for (CompareKind kind : CompareKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final int value;
    private CompareKind(int val) { this.value = (int)val;}
    public int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_int(value, ((CompareKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_int(value, ((CompareKind)obj).value);}
    //</editor-fold>
  };
  
  
  /// Diagnoses an ambiguous conversion.  The partial diagnostic is the
  /// "lead" diagnostic; it will be given two arguments, the source and
  /// target types of the conversion.
  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitConversionSequence::DiagnoseAmbiguousConversion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 9039,
   FQN="clang::ImplicitConversionSequence::DiagnoseAmbiguousConversion", NM="_ZNK5clang26ImplicitConversionSequence27DiagnoseAmbiguousConversionERNS_4SemaENS_14SourceLocationERKNS_17PartialDiagnosticE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang26ImplicitConversionSequence27DiagnoseAmbiguousConversionERNS_4SemaENS_14SourceLocationERKNS_17PartialDiagnosticE")
  //</editor-fold>
  public void DiagnoseAmbiguousConversion(final Sema /*&*/ S, 
                             SourceLocation CaretLoc, 
                             final /*const*/ PartialDiagnostic /*&*/ PDiag) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(CaretLoc), PDiag)), 
              Unnamed_field2.Ambiguous.getFromType()), Unnamed_field2.Ambiguous.getToType()));
      // FIXME: The note limiting machinery is borrowed from
      // OverloadCandidateSet::NoteCandidates; there's an opportunity for
      // refactoring here.
      /*const*/ OverloadsShown ShowOverloads = S.Diags.getShowOverloads();
      /*uint*/int CandsShown = 0;
      //type$ptr</*const*/ pair<NamedDecl /*P*/ , FunctionDecl /*P*/ > /*P*/ > I, /*P*/ E;
      //pair<NamedDecl /*P*/ , FunctionDecl /*P*/ > I, /*P*/ E;
      type$ptr<pair<NamedDecl, FunctionDecl>>  I, /*P*/ E;
      for (I = $tryClone(Unnamed_field2.Ambiguous.begin$Const()) , E = $tryClone(Unnamed_field2.Ambiguous.end$Const()); $noteq_ptr(I, E); I.$preInc()) {        
        if ($greatereq_uint(CandsShown, 4) && ShowOverloads == OverloadsShown.Ovl_Best) {
          break;
        }
        ++CandsShown;
        S.NoteOverloadCandidate(I./*->*/$star().first, I./*->*/$star().second);
      }
      if ($noteq_ptr(I, E)) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(), diag.note_ovl_too_many_candidates)), ((int)(E.$sub(I)))));
      }
    } finally {
      $c$.$destroy();
    }
  }

  
  
  /// dump - Print this implicit conversion sequence to standard
  /// error. Useful for debugging overloading issues.
  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitConversionSequence::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 500,
   FQN="clang::ImplicitConversionSequence::dump", NM="_ZNK5clang26ImplicitConversionSequence4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang26ImplicitConversionSequence4dumpEv")
  //</editor-fold>
  public void dump() /*const*/ {
    final raw_ostream /*&*/ OS = llvm.errs();
    if (isStdInitializerListElement()) {
      OS.$out(/*KEEP_STR*/"Worst std::initializer_list element conversion: ");
    }
    switch (Kind.valueOf(ConversionKind)) {
     case StandardConversion:
      OS.$out(/*KEEP_STR*/"Standard conversion: ");
      Unnamed_field2.Standard.dump();
      break;
     case UserDefinedConversion:
      OS.$out(/*KEEP_STR*/"User-defined conversion: ");
      Unnamed_field2.UserDefined.dump();
      break;
     case EllipsisConversion:
      OS.$out(/*KEEP_STR*/"Ellipsis conversion");
      break;
     case AmbiguousConversion:
      OS.$out(/*KEEP_STR*/"Ambiguous conversion");
      break;
     case BadConversion:
      OS.$out(/*KEEP_STR*/"Bad conversion");
      break;
    }
    
    OS.$out(/*KEEP_STR*/$LF);
  }

  
  @Override public String toString() {
    return "" + "ConversionKind=" + ConversionKind // NOI18N
              + ", StdInitializerListElement=" + StdInitializerListElement // NOI18N
              + ", Unnamed_field2=" + Unnamed_field2; // NOI18N
  }
}
