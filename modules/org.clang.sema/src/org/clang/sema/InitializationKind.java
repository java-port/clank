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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import org.clang.basic.*;


/// \brief Describes the kind of initialization being performed, along with 
/// location information for tokens related to the initialization (equal sign,
/// parentheses).
//<editor-fold defaultstate="collapsed" desc="clang::InitializationKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 448,
 FQN="clang::InitializationKind", NM="_ZN5clang18InitializationKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang18InitializationKindE")
//</editor-fold>
public class InitializationKind {
/*public:*/
  /// \brief The kind of initialization being performed.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationKind::InitKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 451,
   FQN="clang::InitializationKind::InitKind", NM="_ZN5clang18InitializationKind8InitKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang18InitializationKind8InitKindE")
  //</editor-fold>
  public enum InitKind implements Native.ComparableLower {
    IK_Direct(0), ///< Direct initialization
    IK_DirectList(IK_Direct.getValue() + 1), ///< Direct list-initialization
    IK_Copy(IK_DirectList.getValue() + 1), ///< Copy initialization
    IK_Default(IK_Copy.getValue() + 1), ///< Default initialization
    IK_Value(IK_Default.getValue() + 1); ///< Value initialization

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static InitKind valueOf(int val) {
      InitKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final InitKind[] VALUES;
      private static final InitKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (InitKind kind : InitKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new InitKind[min < 0 ? (1-min) : 0];
        VALUES = new InitKind[max >= 0 ? (1+max) : 0];
        for (InitKind kind : InitKind.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private InitKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((InitKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((InitKind)obj).value);}
    //</editor-fold>
  };
/*private:*/
  /// \brief The context of the initialization.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationKind::InitContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 461,
   FQN="clang::InitializationKind::InitContext", NM="_ZN5clang18InitializationKind11InitContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang18InitializationKind11InitContextE")
  //</editor-fold>
  private enum InitContext implements Native.ComparableLower {
    IC_Normal(0), ///< Normal context
    IC_ExplicitConvs(IC_Normal.getValue() + 1), ///< Normal context, but allows explicit conversion funcs
    IC_Implicit(IC_ExplicitConvs.getValue() + 1), ///< Implicit context (value initialization)
    IC_StaticCast(IC_Implicit.getValue() + 1), ///< Static cast context
    IC_CStyleCast(IC_StaticCast.getValue() + 1), ///< C-style cast context
    IC_FunctionalCast(IC_CStyleCast.getValue() + 1); ///< Functional cast context

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static InitContext valueOf(int val) {
      InitContext out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final InitContext[] VALUES;
      private static final InitContext[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (InitContext kind : InitContext.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new InitContext[min < 0 ? (1-min) : 0];
        VALUES = new InitContext[max >= 0 ? (1+max) : 0];
        for (InitContext kind : InitContext.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private InitContext(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((InitContext)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((InitContext)obj).value);}
    //</editor-fold>
  };
  
  /// \brief The kind of initialization being performed.
  private InitKind Kind /*: 8*/;
  
  /// \brief The context of the initialization.
  private InitContext Context /*: 8*/;
  
  /// \brief The source locations involved in the initialization.
  private final SourceLocation Locations[/*3*/];
  
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationKind::InitializationKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 479,
   FQN="clang::InitializationKind::InitializationKind", NM="_ZN5clang18InitializationKindC1ENS0_8InitKindENS0_11InitContextENS_14SourceLocationES3_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang18InitializationKindC1ENS0_8InitKindENS0_11InitContextENS_14SourceLocationES3_S3_")
  //</editor-fold>
  private InitializationKind(InitKind Kind, InitContext Context, SourceLocation Loc1, 
      SourceLocation Loc2, SourceLocation Loc3) {
    // : Kind(Kind), Context(Context), Locations() 
    //START JInit
    this.Kind = Kind;
    this.Context = Context;
    this.Locations = new$T(new SourceLocation [3], ()->new SourceLocation());
    //END JInit
    Locations[0].$assign(Loc1);
    Locations[1].$assign(Loc2);
    Locations[2].$assign(Loc3);
  }

/*public:*/
  /// \brief Create a direct initialization.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationKind::CreateDirect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 490,
   FQN="clang::InitializationKind::CreateDirect", NM="_ZN5clang18InitializationKind12CreateDirectENS_14SourceLocationES1_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang18InitializationKind12CreateDirectENS_14SourceLocationES1_S1_")
  //</editor-fold>
  public static InitializationKind CreateDirect(SourceLocation InitLoc, 
              SourceLocation LParenLoc, 
              SourceLocation RParenLoc) {
    return new InitializationKind(InitKind.IK_Direct, InitContext.IC_Normal, 
        new SourceLocation(InitLoc), new SourceLocation(LParenLoc), new SourceLocation(RParenLoc));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationKind::CreateDirectList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 497,
   FQN="clang::InitializationKind::CreateDirectList", NM="_ZN5clang18InitializationKind16CreateDirectListENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang18InitializationKind16CreateDirectListENS_14SourceLocationE")
  //</editor-fold>
  public static InitializationKind CreateDirectList(SourceLocation InitLoc) {
    return new InitializationKind(InitKind.IK_DirectList, InitContext.IC_Normal, 
        new SourceLocation(InitLoc), new SourceLocation(InitLoc), new SourceLocation(InitLoc));
  }

  
  /// \brief Create a direct initialization due to a cast that isn't a C-style 
  /// or functional cast.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationKind::CreateCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 504,
   FQN="clang::InitializationKind::CreateCast", NM="_ZN5clang18InitializationKind10CreateCastENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang18InitializationKind10CreateCastENS_11SourceRangeE")
  //</editor-fold>
  public static InitializationKind CreateCast(SourceRange TypeRange) {
    return new InitializationKind(InitKind.IK_Direct, InitContext.IC_StaticCast, TypeRange.getBegin(), 
        TypeRange.getBegin(), TypeRange.getEnd());
  }

  
  /// \brief Create a direct initialization for a C-style cast.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationKind::CreateCStyleCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 510,
   FQN="clang::InitializationKind::CreateCStyleCast", NM="_ZN5clang18InitializationKind16CreateCStyleCastENS_14SourceLocationENS_11SourceRangeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang18InitializationKind16CreateCStyleCastENS_14SourceLocationENS_11SourceRangeEb")
  //</editor-fold>
  public static InitializationKind CreateCStyleCast(SourceLocation StartLoc, 
                  SourceRange TypeRange, 
                  boolean InitList) {
    // C++ cast syntax doesn't permit init lists, but C compound literals are
    // exactly that.
    return new InitializationKind(InitList ? InitKind.IK_DirectList : InitKind.IK_Direct, 
        InitContext.IC_CStyleCast, new SourceLocation(StartLoc), TypeRange.getBegin(), 
        TypeRange.getEnd());
  }

  
  /// \brief Create a direct initialization for a functional cast.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationKind::CreateFunctionalCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 521,
   FQN="clang::InitializationKind::CreateFunctionalCast", NM="_ZN5clang18InitializationKind20CreateFunctionalCastENS_11SourceRangeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang18InitializationKind20CreateFunctionalCastENS_11SourceRangeEb")
  //</editor-fold>
  public static InitializationKind CreateFunctionalCast(SourceRange TypeRange, 
                      boolean InitList) {
    return new InitializationKind(InitList ? InitKind.IK_DirectList : InitKind.IK_Direct, 
        InitContext.IC_FunctionalCast, TypeRange.getBegin(), 
        TypeRange.getBegin(), TypeRange.getEnd());
  }

  
  /// \brief Create a copy initialization.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationKind::CreateCopy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 529,
   FQN="clang::InitializationKind::CreateCopy", NM="_ZN5clang18InitializationKind10CreateCopyENS_14SourceLocationES1_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang18InitializationKind10CreateCopyENS_14SourceLocationES1_b")
  //</editor-fold>
  public static InitializationKind CreateCopy(SourceLocation InitLoc, 
            SourceLocation EqualLoc) {
    return CreateCopy(InitLoc, 
            EqualLoc, 
            false);
  }
  public static InitializationKind CreateCopy(SourceLocation InitLoc, 
            SourceLocation EqualLoc, 
            boolean AllowExplicitConvs/*= false*/) {
    return new InitializationKind(InitKind.IK_Copy, 
        AllowExplicitConvs ? InitContext.IC_ExplicitConvs : InitContext.IC_Normal, 
        new SourceLocation(InitLoc), new SourceLocation(EqualLoc), new SourceLocation(EqualLoc));
  }

  
  /// \brief Create a default initialization.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationKind::CreateDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 538,
   FQN="clang::InitializationKind::CreateDefault", NM="_ZN5clang18InitializationKind13CreateDefaultENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang18InitializationKind13CreateDefaultENS_14SourceLocationE")
  //</editor-fold>
  public static InitializationKind CreateDefault(SourceLocation InitLoc) {
    return new InitializationKind(InitKind.IK_Default, InitContext.IC_Normal, new SourceLocation(InitLoc), new SourceLocation(InitLoc), new SourceLocation(InitLoc));
  }

  
  /// \brief Create a value initialization.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationKind::CreateValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 543,
   FQN="clang::InitializationKind::CreateValue", NM="_ZN5clang18InitializationKind11CreateValueENS_14SourceLocationES1_S1_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang18InitializationKind11CreateValueENS_14SourceLocationES1_S1_b")
  //</editor-fold>
  public static InitializationKind CreateValue(SourceLocation InitLoc, 
             SourceLocation LParenLoc, 
             SourceLocation RParenLoc) {
    return CreateValue(InitLoc, 
             LParenLoc, 
             RParenLoc, 
             false);
  }
  public static InitializationKind CreateValue(SourceLocation InitLoc, 
             SourceLocation LParenLoc, 
             SourceLocation RParenLoc, 
             boolean isImplicit/*= false*/) {
    return new InitializationKind(InitKind.IK_Value, isImplicit ? InitContext.IC_Implicit : InitContext.IC_Normal, 
        new SourceLocation(InitLoc), new SourceLocation(LParenLoc), new SourceLocation(RParenLoc));
  }

  
  /// \brief Determine the initialization kind.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationKind::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 552,
   FQN="clang::InitializationKind::getKind", NM="_ZNK5clang18InitializationKind7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang18InitializationKind7getKindEv")
  //</editor-fold>
  public InitKind getKind() /*const*/ {
    return Kind;
  }

  
  /// \brief Determine whether this initialization is an explicit cast.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationKind::isExplicitCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 557,
   FQN="clang::InitializationKind::isExplicitCast", NM="_ZNK5clang18InitializationKind14isExplicitCastEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang18InitializationKind14isExplicitCastEv")
  //</editor-fold>
  public boolean isExplicitCast() /*const*/ {
    return Context.getValue() >= InitContext.IC_StaticCast.getValue();
  }

  
  /// \brief Determine whether this initialization is a C-style cast.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationKind::isCStyleOrFunctionalCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 562,
   FQN="clang::InitializationKind::isCStyleOrFunctionalCast", NM="_ZNK5clang18InitializationKind24isCStyleOrFunctionalCastEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang18InitializationKind24isCStyleOrFunctionalCastEv")
  //</editor-fold>
  public boolean isCStyleOrFunctionalCast() /*const*/ {
    return Context.getValue() >= InitContext.IC_CStyleCast.getValue();
  }

  
  /// \brief Determine whether this is a C-style cast.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationKind::isCStyleCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 567,
   FQN="clang::InitializationKind::isCStyleCast", NM="_ZNK5clang18InitializationKind12isCStyleCastEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang18InitializationKind12isCStyleCastEv")
  //</editor-fold>
  public boolean isCStyleCast() /*const*/ {
    return Context == InitContext.IC_CStyleCast;
  }

  
  /// \brief Determine whether this is a functional-style cast.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationKind::isFunctionalCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 572,
   FQN="clang::InitializationKind::isFunctionalCast", NM="_ZNK5clang18InitializationKind16isFunctionalCastEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang18InitializationKind16isFunctionalCastEv")
  //</editor-fold>
  public boolean isFunctionalCast() /*const*/ {
    return Context == InitContext.IC_FunctionalCast;
  }

  
  /// \brief Determine whether this initialization is an implicit
  /// value-initialization, e.g., as occurs during aggregate
  /// initialization.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationKind::isImplicitValueInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 579,
   FQN="clang::InitializationKind::isImplicitValueInit", NM="_ZNK5clang18InitializationKind19isImplicitValueInitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang18InitializationKind19isImplicitValueInitEv")
  //</editor-fold>
  public boolean isImplicitValueInit() /*const*/ {
    return Context == InitContext.IC_Implicit;
  }

  
  /// \brief Retrieve the location at which initialization is occurring.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationKind::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 582,
   FQN="clang::InitializationKind::getLocation", NM="_ZNK5clang18InitializationKind11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang18InitializationKind11getLocationEv")
  //</editor-fold>
  public SourceLocation getLocation() /*const*/ {
    return new SourceLocation(Locations[0]);
  }

  
  /// \brief Retrieve the source range that covers the initialization.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationKind::getRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 585,
   FQN="clang::InitializationKind::getRange", NM="_ZNK5clang18InitializationKind8getRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang18InitializationKind8getRangeEv")
  //</editor-fold>
  public SourceRange getRange() /*const*/ {
    return new SourceRange(/*NO_COPY*/Locations[0], /*NO_COPY*/Locations[2]);
  }

  
  /// \brief Retrieve the location of the equal sign for copy initialization
  /// (if present).
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationKind::getEqualLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 591,
   FQN="clang::InitializationKind::getEqualLoc", NM="_ZNK5clang18InitializationKind11getEqualLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang18InitializationKind11getEqualLocEv")
  //</editor-fold>
  public SourceLocation getEqualLoc() /*const*/ {
    assert (Kind == InitKind.IK_Copy) : "Only copy initialization has an '='";
    return new SourceLocation(Locations[1]);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationKind::isCopyInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 596,
   FQN="clang::InitializationKind::isCopyInit", NM="_ZNK5clang18InitializationKind10isCopyInitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang18InitializationKind10isCopyInitEv")
  //</editor-fold>
  public boolean isCopyInit() /*const*/ {
    return Kind == InitKind.IK_Copy;
  }

  
  /// \brief Retrieve whether this initialization allows the use of explicit
  ///        constructors.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationKind::AllowExplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 600,
   FQN="clang::InitializationKind::AllowExplicit", NM="_ZNK5clang18InitializationKind13AllowExplicitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang18InitializationKind13AllowExplicitEv")
  //</editor-fold>
  public boolean AllowExplicit() /*const*/ {
    return !isCopyInit();
  }

  
  /// \brief Retrieve whether this initialization allows the use of explicit
  /// conversion functions when binding a reference. If the reference is the
  /// first parameter in a copy or move constructor, such conversions are
  /// permitted even though we are performing copy-initialization.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationKind::allowExplicitConversionFunctionsInRefBinding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 606,
   FQN="clang::InitializationKind::allowExplicitConversionFunctionsInRefBinding", NM="_ZNK5clang18InitializationKind44allowExplicitConversionFunctionsInRefBindingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang18InitializationKind44allowExplicitConversionFunctionsInRefBindingEv")
  //</editor-fold>
  public boolean allowExplicitConversionFunctionsInRefBinding() /*const*/ {
    return !isCopyInit() || Context == InitContext.IC_ExplicitConvs;
  }

  
  /// \brief Retrieve the source range containing the locations of the open
  /// and closing parentheses for value and direct initializations.
  //<editor-fold defaultstate="collapsed" desc="clang::InitializationKind::getParenRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 612,
   FQN="clang::InitializationKind::getParenRange", NM="_ZNK5clang18InitializationKind13getParenRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZNK5clang18InitializationKind13getParenRangeEv")
  //</editor-fold>
  public SourceRange getParenRange() /*const*/ {
    assert ((Kind == InitKind.IK_Direct || Kind == InitKind.IK_Value)) : "Only direct- and value-initialization have parentheses";
    return new SourceRange(/*NO_COPY*/Locations[1], /*NO_COPY*/Locations[2]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InitializationKind::InitializationKind">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 448,
   FQN="clang::InitializationKind::InitializationKind", NM="_ZN5clang18InitializationKindC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang18InitializationKindC1ERKS0_")
  //</editor-fold>
  public /*inline*/ InitializationKind(final /*const*/ InitializationKind /*&*/ $Prm0) {
    // : Kind(.Kind), Context(.Context), Locations(.Locations[__i0]) 
    //START JInit
    this.Kind = $Prm0.Kind;
    this.Context = $Prm0.Context;
    this.Locations = new SourceLocation[] {new SourceLocation($Prm0.Locations[0]), new SourceLocation($Prm0.Locations[1]), new SourceLocation($Prm0.Locations[2])};
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InitializationKind::InitializationKind">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 448,
   FQN="clang::InitializationKind::InitializationKind", NM="_ZN5clang18InitializationKindC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang18InitializationKindC1EOS0_")
  //</editor-fold>
  public /*inline*/ InitializationKind(JD$Move _dparam, final InitializationKind /*&&*/$Prm0) {
    // : Kind(static_cast<InitializationKind &&>().Kind), Context(static_cast<InitializationKind &&>().Context), Locations(static_cast<SourceLocation &&>(static_cast<InitializationKind &&>().Locations[__i0])) 
    //START JInit
    this.Kind = $Prm0.Kind;
    this.Context = $Prm0.Context;
    this.Locations = new SourceLocation[] {$Prm0.Locations[0], $Prm0.Locations[1], $Prm0.Locations[2]};
    //END JInit
    $Prm0.Locations[0] = null;$Prm0.Locations[1] = null;$Prm0.Locations[2] = null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::InitializationKind::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Initialization.h", line = 448,
   FQN="clang::InitializationKind::operator=", NM="_ZN5clang18InitializationKindaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN5clang18InitializationKindaSEOS0_")
  //</editor-fold>
  public /*inline*/ InitializationKind /*&*/ $assignMove(final InitializationKind /*&&*/$Prm0) {
    this.Kind = $Prm0.Kind;
    this.Context = $Prm0.Context;
    __builtin_memcpy($AddrOf(this.Locations), $AddrOf($Prm0.Locations)/*, SKIP_ARG*/, false);
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", Context=" + "[InitContext]" // NOI18N
              + ", Locations=" + Locations; // NOI18N
  }
}
