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
import static org.llvm.adt.ADTAliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.sema.java.SemaRTTI.*;

//<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 398,
 FQN="clang::sema::CapturingScopeInfo", NM="_ZN5clang4sema18CapturingScopeInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema18CapturingScopeInfoE")
//</editor-fold>
public class CapturingScopeInfo extends /*public*/ FunctionScopeInfo implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::CapturingScopeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 400,
   FQN="clang::sema::CapturingScopeInfo::CapturingScopeInfo", NM="_ZN5clang4sema18CapturingScopeInfoC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang4sema18CapturingScopeInfoC1ERKS1_")
  //</editor-fold>
  protected CapturingScopeInfo(final /*const*/ CapturingScopeInfo /*&*/ $Prm0) {
    // : FunctionScopeInfo(), ImpCaptureStyle(.ImpCaptureStyle), CaptureMap(.CaptureMap), CXXThisCaptureIndex(.CXXThisCaptureIndex), Captures(.Captures), HasImplicitReturnType(.HasImplicitReturnType), ReturnType(.ReturnType)/* = default*/ 
    //START JInit
    super($Prm0);
    this.ImpCaptureStyle = $Prm0.ImpCaptureStyle;
    this.CaptureMap = new DenseMapTypeUInt<VarDecl /*P*/ >($Prm0.CaptureMap);
    this.CXXThisCaptureIndex = $Prm0.CXXThisCaptureIndex;
    this.Captures = new SmallVector<Capture>($Prm0.Captures);
    this.HasImplicitReturnType = $Prm0.HasImplicitReturnType;
    this.ReturnType = new QualType($Prm0.ReturnType);
    //END JInit
  }


/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::ImplicitCaptureStyle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 403,
   FQN="clang::sema::CapturingScopeInfo::ImplicitCaptureStyle", NM="_ZN5clang4sema18CapturingScopeInfo20ImplicitCaptureStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema18CapturingScopeInfo20ImplicitCaptureStyleE")
  //</editor-fold>
  public enum ImplicitCaptureStyle implements Native.ComparableLower {
    ImpCap_None(0),
    ImpCap_LambdaByval(ImpCap_None.getValue() + 1),
    ImpCap_LambdaByref(ImpCap_LambdaByval.getValue() + 1),
    ImpCap_Block(ImpCap_LambdaByref.getValue() + 1),
    ImpCap_CapturedRegion(ImpCap_Block.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ImplicitCaptureStyle valueOf(int val) {
      ImplicitCaptureStyle out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ImplicitCaptureStyle[] VALUES;
      private static final ImplicitCaptureStyle[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ImplicitCaptureStyle kind : ImplicitCaptureStyle.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ImplicitCaptureStyle[min < 0 ? (1-min) : 0];
        VALUES = new ImplicitCaptureStyle[max >= 0 ? (1+max) : 0];
        for (ImplicitCaptureStyle kind : ImplicitCaptureStyle.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private ImplicitCaptureStyle(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ImplicitCaptureStyle)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ImplicitCaptureStyle)obj).value);}
    //</editor-fold>
  };
  
  public ImplicitCaptureStyle ImpCaptureStyle;
  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::Capture">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 410,
   FQN="clang::sema::CapturingScopeInfo::Capture", NM="_ZN5clang4sema18CapturingScopeInfo7CaptureE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema18CapturingScopeInfo7CaptureE")
  //</editor-fold>
  public static class Capture implements NativeCloneable<Capture> {
    // There are three categories of capture: capturing 'this', capturing
    // local variables, and C++1y initialized captures (which can have an
    // arbitrary initializer, and don't really capture in the traditional
    // sense at all).
    //
    // There are three ways to capture a local variable:
    //  - capture by copy in the C++11 sense,
    //  - capture by reference in the C++11 sense, and
    //  - __block capture.
    // Lambdas explicitly specify capture by copy or capture by reference.
    // For blocks, __block capture applies to variables with that annotation,
    // variables of reference type are captured by reference, and other
    // variables are captured by copy.
    //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::Capture::CaptureKind">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 424,
     FQN="clang::sema::CapturingScopeInfo::Capture::CaptureKind", NM="_ZN5clang4sema18CapturingScopeInfo7Capture11CaptureKindE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema18CapturingScopeInfo7Capture11CaptureKindE")
    //</editor-fold>
    private enum CaptureKind implements Native.ComparableLower {
      Cap_ByCopy(0),
      Cap_ByRef(Cap_ByCopy.getValue() + 1),
      Cap_Block(Cap_ByRef.getValue() + 1),
      Cap_VLA(Cap_Block.getValue() + 1);

      //<editor-fold defaultstate="collapsed" desc="hidden">
      public static CaptureKind valueOf(int val) {
        CaptureKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
        assert out != null : "no value for " + val;
        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
        return out;
      }

      private static final class Values {
        private static final CaptureKind[] VALUES;
        private static final CaptureKind[] _VALUES; // [0] not used
        static {
          int max = 0;
          int min = 0;
          for (CaptureKind kind : CaptureKind.values()) {
            if (kind.value > max) { max = kind.value; }
            if (kind.value < min) { min = kind.value; }
          }
          _VALUES = new CaptureKind[min < 0 ? (1-min) : 0];
          VALUES = new CaptureKind[max >= 0 ? (1+max) : 0];
          for (CaptureKind kind : CaptureKind.values()) {
            if (kind.value < 0) {
              _VALUES[-kind.value] = kind;
            } else {
              VALUES[kind.value] = kind;
            }
          }
        }
      }

      private final /*uint*/int value;
      private CaptureKind(int val) { this.value = (/*uint*/int)val;}
      public /*uint*/int getValue() { return value;}
      @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((CaptureKind)obj).value);}
      @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((CaptureKind)obj).value);}
      //</editor-fold>
    };
    //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::Capture::(anonymous)">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 427,
     FQN="clang::sema::CapturingScopeInfo::Capture::(anonymous)", NM="_ZN5clang4sema18CapturingScopeInfo7CaptureE_Unnamed_enum1",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema18CapturingScopeInfo7CaptureE_Unnamed_enum1")
    //</editor-fold>
    /*enum ANONYMOUS_INT_CONSTANTS {*/
      public static final /*uint*/int IsNestedCapture = 0x1;
      public static final /*uint*/int IsThisCaptured = 0x2;
    /*}*/;
    /// The variable being captured (if we are not capturing 'this') and whether
    /// this is a nested capture, and whether we are capturing 'this'
    private PointerIntPair<VarDecl /*P*/ > VarAndNestedAndThis;
    /// Expression to initialize a field of the given type, and the kind of
    /// capture (if this is a capture and not an init-capture). The expression
    /// is only required if we are capturing ByVal and the variable's type has
    /// a non-trivial copy constructor.
    private PointerEnum2Pair<Object, CaptureKind> InitExprAndCaptureKind;
    
    /// \brief The source location at which the first capture occurred.
    private SourceLocation Loc;
    
    /// \brief The location of the ellipsis that expands a parameter pack.
    private SourceLocation EllipsisLoc;
    
    /// \brief The type as it was captured, which is in effect the type of the
    /// non-static data member that would hold the capture.
    private QualType CaptureType;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::Capture::Capture">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 451,
     FQN="clang::sema::CapturingScopeInfo::Capture::Capture", NM="_ZN5clang4sema18CapturingScopeInfo7CaptureC1EPNS_7VarDeclEbbbNS_14SourceLocationES5_NS_8QualTypeEPNS_4ExprE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema18CapturingScopeInfo7CaptureC1EPNS_7VarDeclEbbbNS_14SourceLocationES5_NS_8QualTypeEPNS_4ExprE")
    //</editor-fold>
    public Capture(VarDecl /*P*/ Var, boolean Block, boolean ByRef, boolean IsNested, 
        SourceLocation Loc, SourceLocation EllipsisLoc, 
        QualType CaptureType, Expr /*P*/ Cpy) {
      // : VarAndNestedAndThis(Var, IsNested ? IsNestedCapture : 0), InitExprAndCaptureKind(Cpy, !Var ? Cap_VLA : Block ? Cap_Block : ByRef ? Cap_ByRef : Cap_ByCopy), Loc(Loc), EllipsisLoc(EllipsisLoc), CaptureType(CaptureType) 
      //START JInit
      this.VarAndNestedAndThis = new PointerIntPair<VarDecl /*P*/ >(Var, IsNested ? IsNestedCapture : 0);
      this.InitExprAndCaptureKind = new PointerEnum2Pair<Object, CaptureKind>(Cpy, !(Var != null) ? CaptureKind.Cap_VLA : Block ? CaptureKind.Cap_Block : ByRef ? CaptureKind.Cap_ByRef : CaptureKind.Cap_ByCopy);
      this.Loc = new SourceLocation(Loc);
      this.EllipsisLoc = new SourceLocation(EllipsisLoc);
      this.CaptureType = new QualType(CaptureType);
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::Capture::IsThisCapture">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 460,
     FQN="clang::sema::CapturingScopeInfo::Capture::IsThisCapture", NM="_ZN5clang4sema18CapturingScopeInfo7Capture13IsThisCaptureE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema18CapturingScopeInfo7Capture13IsThisCaptureE")
    //</editor-fold>
    public enum IsThisCapture implements Native.ComparableLower {
      ThisCapture(0);

      //<editor-fold defaultstate="collapsed" desc="hidden">
      public static IsThisCapture valueOf(int val) {
        IsThisCapture out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
        assert out != null : "no value for " + val;
        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
        return out;
      }

      private static final class Values {
        private static final IsThisCapture[] VALUES;
        private static final IsThisCapture[] _VALUES; // [0] not used
        static {
          int max = 0;
          int min = 0;
          for (IsThisCapture kind : IsThisCapture.values()) {
            if (kind.value > max) { max = kind.value; }
            if (kind.value < min) { min = kind.value; }
          }
          _VALUES = new IsThisCapture[min < 0 ? (1-min) : 0];
          VALUES = new IsThisCapture[max >= 0 ? (1+max) : 0];
          for (IsThisCapture kind : IsThisCapture.values()) {
            if (kind.value < 0) {
              _VALUES[-kind.value] = kind;
            } else {
              VALUES[kind.value] = kind;
            }
          }
        }
      }

      private final /*uint*/int value;
      private IsThisCapture(int val) { this.value = (/*uint*/int)val;}
      public /*uint*/int getValue() { return value;}
      @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((IsThisCapture)obj).value);}
      @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((IsThisCapture)obj).value);}
      //</editor-fold>
    };
    //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::Capture::Capture">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 461,
     FQN="clang::sema::CapturingScopeInfo::Capture::Capture", NM="_ZN5clang4sema18CapturingScopeInfo7CaptureC1ENS2_13IsThisCaptureEbNS_14SourceLocationENS_8QualTypeEPNS_4ExprEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema18CapturingScopeInfo7CaptureC1ENS2_13IsThisCaptureEbNS_14SourceLocationENS_8QualTypeEPNS_4ExprEb")
    //</editor-fold>
    public Capture(IsThisCapture $Prm0, boolean IsNested, SourceLocation Loc, 
        QualType CaptureType, Expr /*P*/ Cpy, /*const*/boolean ByCopy) {
      // : VarAndNestedAndThis(null, (IsThisCaptured | (IsNested ? IsNestedCapture : 0))), InitExprAndCaptureKind(Cpy, ByCopy ? Cap_ByCopy : Cap_ByRef), Loc(Loc), EllipsisLoc(), CaptureType(CaptureType) 
      //START JInit
      this.VarAndNestedAndThis = new PointerIntPair<VarDecl /*P*/ >((VarDecl /*P*/ )null, (IsThisCaptured | (IsNested ? IsNestedCapture : 0)));
      this.InitExprAndCaptureKind = new PointerEnum2Pair<Object, CaptureKind>(Cpy, ByCopy ? CaptureKind.Cap_ByCopy : CaptureKind.Cap_ByRef);
      this.Loc = new SourceLocation(Loc);
      this.EllipsisLoc = new SourceLocation();
      this.CaptureType = new QualType(CaptureType);
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::Capture::isThisCapture">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 468,
     FQN="clang::sema::CapturingScopeInfo::Capture::isThisCapture", NM="_ZNK5clang4sema18CapturingScopeInfo7Capture13isThisCaptureEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZNK5clang4sema18CapturingScopeInfo7Capture13isThisCaptureEv")
    //</editor-fold>
    public boolean isThisCapture() /*const*/ {
      return ((VarAndNestedAndThis.getInt() & IsThisCaptured) != 0);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::Capture::isVariableCapture">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 471,
     FQN="clang::sema::CapturingScopeInfo::Capture::isVariableCapture", NM="_ZNK5clang4sema18CapturingScopeInfo7Capture17isVariableCaptureEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZNK5clang4sema18CapturingScopeInfo7Capture17isVariableCaptureEv")
    //</editor-fold>
    public boolean isVariableCapture() /*const*/ {
      return !isThisCapture() && !isVLATypeCapture();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::Capture::isCopyCapture">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 474,
     FQN="clang::sema::CapturingScopeInfo::Capture::isCopyCapture", NM="_ZNK5clang4sema18CapturingScopeInfo7Capture13isCopyCaptureEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZNK5clang4sema18CapturingScopeInfo7Capture13isCopyCaptureEv")
    //</editor-fold>
    public boolean isCopyCapture() /*const*/ {
      return InitExprAndCaptureKind.getInt() == CaptureKind.Cap_ByCopy;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::Capture::isReferenceCapture">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 477,
     FQN="clang::sema::CapturingScopeInfo::Capture::isReferenceCapture", NM="_ZNK5clang4sema18CapturingScopeInfo7Capture18isReferenceCaptureEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZNK5clang4sema18CapturingScopeInfo7Capture18isReferenceCaptureEv")
    //</editor-fold>
    public boolean isReferenceCapture() /*const*/ {
      return InitExprAndCaptureKind.getInt() == CaptureKind.Cap_ByRef;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::Capture::isBlockCapture">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 480,
     FQN="clang::sema::CapturingScopeInfo::Capture::isBlockCapture", NM="_ZNK5clang4sema18CapturingScopeInfo7Capture14isBlockCaptureEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZNK5clang4sema18CapturingScopeInfo7Capture14isBlockCaptureEv")
    //</editor-fold>
    public boolean isBlockCapture() /*const*/ {
      return InitExprAndCaptureKind.getInt() == CaptureKind.Cap_Block;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::Capture::isVLATypeCapture">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 483,
     FQN="clang::sema::CapturingScopeInfo::Capture::isVLATypeCapture", NM="_ZNK5clang4sema18CapturingScopeInfo7Capture16isVLATypeCaptureEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZNK5clang4sema18CapturingScopeInfo7Capture16isVLATypeCaptureEv")
    //</editor-fold>
    public boolean isVLATypeCapture() /*const*/ {
      return InitExprAndCaptureKind.getInt() == CaptureKind.Cap_VLA;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::Capture::isNested">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 486,
     FQN="clang::sema::CapturingScopeInfo::Capture::isNested", NM="_ZNK5clang4sema18CapturingScopeInfo7Capture8isNestedEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZNK5clang4sema18CapturingScopeInfo7Capture8isNestedEv")
    //</editor-fold>
    public boolean isNested() /*const*/ {
      return ((VarAndNestedAndThis.getInt() & IsNestedCapture) != 0);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::Capture::getVariable">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 490,
     FQN="clang::sema::CapturingScopeInfo::Capture::getVariable", NM="_ZNK5clang4sema18CapturingScopeInfo7Capture11getVariableEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZNK5clang4sema18CapturingScopeInfo7Capture11getVariableEv")
    //</editor-fold>
    public VarDecl /*P*/ getVariable() /*const*/ {
      return VarAndNestedAndThis.getPointer();
    }

    
    /// \brief Retrieve the location at which this variable was captured.
    //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::Capture::getLocation">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 495,
     FQN="clang::sema::CapturingScopeInfo::Capture::getLocation", NM="_ZNK5clang4sema18CapturingScopeInfo7Capture11getLocationEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZNK5clang4sema18CapturingScopeInfo7Capture11getLocationEv")
    //</editor-fold>
    public SourceLocation getLocation() /*const*/ {
      return new SourceLocation(Loc);
    }

    
    /// \brief Retrieve the source location of the ellipsis, whose presence
    /// indicates that the capture is a pack expansion.
    //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::Capture::getEllipsisLoc">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 499,
     FQN="clang::sema::CapturingScopeInfo::Capture::getEllipsisLoc", NM="_ZNK5clang4sema18CapturingScopeInfo7Capture14getEllipsisLocEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZNK5clang4sema18CapturingScopeInfo7Capture14getEllipsisLocEv")
    //</editor-fold>
    public SourceLocation getEllipsisLoc() /*const*/ {
      return new SourceLocation(EllipsisLoc);
    }

    
    /// \brief Retrieve the capture type for this capture, which is effectively
    /// the type of the non-static data member in the lambda/block structure
    /// that would store this capture.
    //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::Capture::getCaptureType">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 504,
     FQN="clang::sema::CapturingScopeInfo::Capture::getCaptureType", NM="_ZNK5clang4sema18CapturingScopeInfo7Capture14getCaptureTypeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZNK5clang4sema18CapturingScopeInfo7Capture14getCaptureTypeEv")
    //</editor-fold>
    public QualType getCaptureType() /*const*/ {
      assert (!isThisCapture());
      return new QualType(CaptureType);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::Capture::getInitExpr">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 509,
     FQN="clang::sema::CapturingScopeInfo::Capture::getInitExpr", NM="_ZNK5clang4sema18CapturingScopeInfo7Capture11getInitExprEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZNK5clang4sema18CapturingScopeInfo7Capture11getInitExprEv")
    //</editor-fold>
    public Expr /*P*/ getInitExpr() /*const*/ {
      assert (!isVLATypeCapture()) : "no init expression for type capture";
      return ((/*static_cast*/Expr /*P*/ )(InitExprAndCaptureKind.getPointer()));
    }


    //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::Capture::Capture">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 410,
     FQN="clang::sema::CapturingScopeInfo::Capture::Capture", NM="_ZN5clang4sema18CapturingScopeInfo7CaptureC1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang4sema18CapturingScopeInfo7CaptureC1ERKS2_")
    //</editor-fold>
    public /*inline*/ Capture(final /*const*/ Capture /*&*/ $Prm0) {
      // : VarAndNestedAndThis(.VarAndNestedAndThis), InitExprAndCaptureKind(.InitExprAndCaptureKind), Loc(.Loc), EllipsisLoc(.EllipsisLoc), CaptureType(.CaptureType) 
      //START JInit
      this.VarAndNestedAndThis = new PointerIntPair<VarDecl /*P*/ >($Prm0.VarAndNestedAndThis);
      this.InitExprAndCaptureKind = new PointerEnum2Pair<Object, CaptureKind>($Prm0.InitExprAndCaptureKind);
      this.Loc = new SourceLocation($Prm0.Loc);
      this.EllipsisLoc = new SourceLocation($Prm0.EllipsisLoc);
      this.CaptureType = new QualType($Prm0.CaptureType);
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::Capture::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 410,
     FQN="clang::sema::CapturingScopeInfo::Capture::operator=", NM="_ZN5clang4sema18CapturingScopeInfo7CaptureaSERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang4sema18CapturingScopeInfo7CaptureaSERKS2_")
    //</editor-fold>
    public /*inline*/ Capture /*&*/ $assign(final /*const*/ Capture /*&*/ $Prm0) {
      this.VarAndNestedAndThis.$assign($Prm0.VarAndNestedAndThis);
      this.InitExprAndCaptureKind.$assign($Prm0.InitExprAndCaptureKind);
      this.Loc.$assign($Prm0.Loc);
      this.EllipsisLoc.$assign($Prm0.EllipsisLoc);
      this.CaptureType.$assign($Prm0.CaptureType);
      return /*Deref*/this;
    }

    public Capture() {
      this.VarAndNestedAndThis = new PointerIntPair<VarDecl /*P*/ >();
      this.InitExprAndCaptureKind = new PointerEnum2Pair<Object, CaptureKind>();
      this.Loc = new SourceLocation();
      this.EllipsisLoc = new SourceLocation();
      this.CaptureType = new QualType();      
    }
    
    @Override public Capture clone() {
      return new Capture(this);
    }
    
    @Override public String toString() {
      return "" + "VarAndNestedAndThis=" + VarAndNestedAndThis // NOI18N
                + ", InitExprAndCaptureKind=" + InitExprAndCaptureKind // NOI18N
                + ", Loc=" + Loc // NOI18N
                + ", EllipsisLoc=" + EllipsisLoc // NOI18N
                + ", CaptureType=" + CaptureType; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::CapturingScopeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 515,
   FQN="clang::sema::CapturingScopeInfo::CapturingScopeInfo", NM="_ZN5clang4sema18CapturingScopeInfoC1ERNS_17DiagnosticsEngineENS1_20ImplicitCaptureStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema18CapturingScopeInfoC1ERNS_17DiagnosticsEngineENS1_20ImplicitCaptureStyleE")
  //</editor-fold>
  public CapturingScopeInfo(final DiagnosticsEngine /*&*/ Diag, ImplicitCaptureStyle Style) {
    // : FunctionScopeInfo(Diag), ImpCaptureStyle(Style), CaptureMap(), CXXThisCaptureIndex(0), Captures(), HasImplicitReturnType(false), ReturnType() 
    //START JInit
    super(Diag);
    this.ImpCaptureStyle = Style;
    this.CaptureMap = new DenseMapTypeUInt<VarDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.CXXThisCaptureIndex = 0;
    this.Captures = new SmallVector<Capture>(4, new Capture());
    this.HasImplicitReturnType = false;
    this.ReturnType = new QualType();
    //END JInit
  }

  
  /// CaptureMap - A map of captured variables to (index+1) into Captures.
  public DenseMapTypeUInt<VarDecl /*P*/ > CaptureMap;
  
  /// CXXThisCaptureIndex - The (index+1) of the capture of 'this';
  /// zero if 'this' is not captured.
  public /*uint*/int CXXThisCaptureIndex;
  
  /// Captures - The captures.
  public SmallVector<Capture> Captures;
  
  /// \brief - Whether the target type of return statements in this context
  /// is deduced (e.g. a lambda or block with omitted return type).
  public boolean HasImplicitReturnType;
  
  /// ReturnType - The target type of return statements in this context,
  /// or null if unknown.
  public QualType ReturnType;
  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::addCapture">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 538,
   FQN="clang::sema::CapturingScopeInfo::addCapture", NM="_ZN5clang4sema18CapturingScopeInfo10addCaptureEPNS_7VarDeclEbbbNS_14SourceLocationES4_NS_8QualTypeEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema18CapturingScopeInfo10addCaptureEPNS_7VarDeclEbbbNS_14SourceLocationES4_NS_8QualTypeEPNS_4ExprE")
  //</editor-fold>
  public void addCapture(VarDecl /*P*/ Var, boolean isBlock, boolean isByref, boolean isNested, 
            SourceLocation Loc, SourceLocation EllipsisLoc, 
            QualType CaptureType, Expr /*P*/ Cpy) {
    Captures.push_back(new Capture(Var, isBlock, isByref, isNested, new SourceLocation(Loc), 
            new SourceLocation(EllipsisLoc), new QualType(CaptureType), Cpy));
    CaptureMap.$set(Var, Captures.size());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::addVLATypeCapture">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 546,
   FQN="clang::sema::CapturingScopeInfo::addVLATypeCapture", NM="_ZN5clang4sema18CapturingScopeInfo17addVLATypeCaptureENS_14SourceLocationENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema18CapturingScopeInfo17addVLATypeCaptureENS_14SourceLocationENS_8QualTypeE")
  //</editor-fold>
  public void addVLATypeCapture(SourceLocation Loc, QualType CaptureType) {
    Captures.push_back(new Capture(/*Var*/ (VarDecl /*P*/ )null, /*isBlock*/ false, 
            /*isByref*/ false, /*isNested*/ false, new SourceLocation(Loc), 
            /*EllipsisLoc*/ new SourceLocation(), new QualType(CaptureType), 
            /*Cpy*/ (Expr /*P*/ )null));
  }

  
  // Note, we do not need to add the type of 'this' since that is always
  // retrievable from Sema::getCurrentThisType - and is also encoded within the
  // type of the corresponding FieldDecl.
  //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::addThisCapture">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 876,
   FQN="clang::sema::CapturingScopeInfo::addThisCapture", NM="_ZN5clang4sema18CapturingScopeInfo14addThisCaptureEbNS_14SourceLocationEPNS_4ExprEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema18CapturingScopeInfo14addThisCaptureEbNS_14SourceLocationEPNS_4ExprEb")
  //</editor-fold>
  public /*inline*/ void addThisCapture(boolean isNested, SourceLocation Loc, 
                Expr /*P*/ Cpy, 
                /*const*/boolean ByCopy) {
    Captures.push_back(new Capture(Capture.IsThisCapture.ThisCapture, isNested, new SourceLocation(Loc), new QualType(), 
            Cpy, ByCopy));
    CXXThisCaptureIndex = Captures.size();
  }

  
  /// \brief Determine whether the C++ 'this' is captured.
  //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::isCXXThisCaptured">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 560,
   FQN="clang::sema::CapturingScopeInfo::isCXXThisCaptured", NM="_ZNK5clang4sema18CapturingScopeInfo17isCXXThisCapturedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZNK5clang4sema18CapturingScopeInfo17isCXXThisCapturedEv")
  //</editor-fold>
  public boolean isCXXThisCaptured() /*const*/ {
    return CXXThisCaptureIndex != 0;
  }

  
  /// \brief Retrieve the capture of C++ 'this', if it has been captured.
  //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::getCXXThisCapture">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 563,
   FQN="clang::sema::CapturingScopeInfo::getCXXThisCapture", NM="_ZN5clang4sema18CapturingScopeInfo17getCXXThisCaptureEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema18CapturingScopeInfo17getCXXThisCaptureEv")
  //</editor-fold>
  public Capture /*&*/ getCXXThisCapture() {
    assert (isCXXThisCaptured()) : "this has not been captured";
    return Captures.$at(CXXThisCaptureIndex - 1);
  }

  
  /// \brief Determine whether the given variable has been captured.
  //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::isCaptured">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 569,
   FQN="clang::sema::CapturingScopeInfo::isCaptured", NM="_ZNK5clang4sema18CapturingScopeInfo10isCapturedEPNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZNK5clang4sema18CapturingScopeInfo10isCapturedEPNS_7VarDeclE")
  //</editor-fold>
  public boolean isCaptured(VarDecl /*P*/ Var) /*const*/ {
    return (CaptureMap.count(Var) != 0);
  }

  
  /// \brief Determine whether the given variable-array type has been captured.
  //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::isVLATypeCaptured">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp", line = 106,
   FQN="clang::sema::CapturingScopeInfo::isVLATypeCaptured", NM="_ZNK5clang4sema18CapturingScopeInfo17isVLATypeCapturedEPKNS_17VariableArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZNK5clang4sema18CapturingScopeInfo17isVLATypeCapturedEPKNS_17VariableArrayTypeE")
  //</editor-fold>
  public boolean isVLATypeCaptured(/*const*/ VariableArrayType /*P*/ VAT) /*const*/ {
    RecordDecl /*P*/ RD = null;
    {
      /*const*/ LambdaScopeInfo /*P*/ LSI = dyn_cast_LambdaScopeInfo(this);
      if ((LSI != null)) {
        RD = LSI.Lambda;
      } else {
        /*const*/ CapturedRegionScopeInfo /*P*/ CRSI = dyn_cast_CapturedRegionScopeInfo(this);
        if ((CRSI != null)) {
          RD = CRSI.TheRecordDecl;
        }
      }
    }
    if ((RD != null)) {
      for (FieldDecl /*P*/ FD : RD.fields()) {
        if (FD.hasCapturedVLAType() && FD.getCapturedVLAType() == VAT) {
          return true;
        }
      }
    }
    return false;
  }

  
  /// \brief Retrieve the capture of the given variable, if it has been
  /// captured already.
  //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::getCapture">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 578,
   FQN="clang::sema::CapturingScopeInfo::getCapture", NM="_ZN5clang4sema18CapturingScopeInfo10getCaptureEPNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema18CapturingScopeInfo10getCaptureEPNS_7VarDeclE")
  //</editor-fold>
  public Capture /*&*/ getCapture(VarDecl /*P*/ Var) {
    assert (isCaptured(Var)) : "Variable has not been captured";
    return Captures.$at(CaptureMap.$at_T1$C$R(Var) - 1);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::getCapture">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 583,
   FQN="clang::sema::CapturingScopeInfo::getCapture", NM="_ZNK5clang4sema18CapturingScopeInfo10getCaptureEPNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZNK5clang4sema18CapturingScopeInfo10getCaptureEPNS_7VarDeclE")
  //</editor-fold>
  public /*const*/ Capture /*&*/ getCapture$Const(VarDecl /*P*/ Var) /*const*/ {
    DenseMapIteratorTypeUInt<VarDecl> Known = CaptureMap.find$Const(Var);
    assert (Known.$noteq(CaptureMap.end$Const())) : "Variable has not been captured";
    return Captures.$at$Const(Known.$arrow().second - 1);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 590,
   FQN="clang::sema::CapturingScopeInfo::classof", NM="_ZN5clang4sema18CapturingScopeInfo7classofEPKNS0_17FunctionScopeInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema18CapturingScopeInfo7classofEPKNS0_17FunctionScopeInfoE")
  //</editor-fold>
  public static boolean classof(/*const*/ FunctionScopeInfo /*P*/ FSI) {
    return FSI.Kind == ScopeKind.SK_Block || FSI.Kind == ScopeKind.SK_Lambda
       || FSI.Kind == ScopeKind.SK_CapturedRegion;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::sema::CapturingScopeInfo::~CapturingScopeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 398,
   FQN="clang::sema::CapturingScopeInfo::~CapturingScopeInfo", NM="_ZN5clang4sema18CapturingScopeInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema18CapturingScopeInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Captures.$destroy();
    CaptureMap.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "ImpCaptureStyle=" + ImpCaptureStyle // NOI18N
              + ", CaptureMap=" + CaptureMap // NOI18N
              + ", CXXThisCaptureIndex=" + CXXThisCaptureIndex // NOI18N
              + ", Captures=" + Captures // NOI18N
              + ", HasImplicitReturnType=" + HasImplicitReturnType // NOI18N
              + ", ReturnType=" + ReturnType // NOI18N
              + super.toString(); // NOI18N
  }
}
