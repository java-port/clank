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

package org.clang.analysis.analyses.analyze_format_string;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.clang.ast.*;
import org.clang.analysis.analyses.analyze_format_string.*;

//<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ArgType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 236,
 FQN="clang::analyze_format_string::ArgType", NM="_ZN5clang21analyze_format_string7ArgTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string7ArgTypeE")
//</editor-fold>
public class ArgType {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ArgType::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 238,
   FQN="clang::analyze_format_string::ArgType::Kind", NM="_ZN5clang21analyze_format_string7ArgType4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string7ArgType4KindE")
  //</editor-fold>
  public enum Kind implements Native.ComparableLower {
    UnknownTy(0),
    InvalidTy(UnknownTy.getValue() + 1),
    SpecificTy(InvalidTy.getValue() + 1),
    ObjCPointerTy(SpecificTy.getValue() + 1),
    CPointerTy(ObjCPointerTy.getValue() + 1),
    AnyCharTy(CPointerTy.getValue() + 1),
    CStrTy(AnyCharTy.getValue() + 1),
    WCStrTy(CStrTy.getValue() + 1),
    WIntTy(WCStrTy.getValue() + 1);

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
    private Kind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Kind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Kind)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ArgType::MatchKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 241,
   FQN="clang::analyze_format_string::ArgType::MatchKind", NM="_ZN5clang21analyze_format_string7ArgType9MatchKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string7ArgType9MatchKindE")
  //</editor-fold>
  public enum MatchKind implements Native.ComparableLower {
    NoMatch(0),
    Match(1),
    NoMatchPedantic(Match.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static MatchKind valueOf(int val) {
      MatchKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final MatchKind[] VALUES;
      private static final MatchKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (MatchKind kind : MatchKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new MatchKind[min < 0 ? (1-min) : 0];
        VALUES = new MatchKind[max >= 0 ? (1+max) : 0];
        for (MatchKind kind : MatchKind.values()) {
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
    private MatchKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((MatchKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((MatchKind)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private /*const*/ Kind K;
  private QualType T;
  private /*const*/char$ptr/*char P*/ Name;
  private boolean Ptr;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ArgType::ArgType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 249,
   FQN="clang::analyze_format_string::ArgType::ArgType", NM="_ZN5clang21analyze_format_string7ArgTypeC1ENS1_4KindEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string7ArgTypeC1ENS1_4KindEPKc")
  //</editor-fold>
  public ArgType() {
    this(Kind.UnknownTy, (/*const*/char$ptr/*char P*/ )null);
  }
  public ArgType(Kind k/*= UnknownTy*/) {
    this(k, (/*const*/char$ptr/*char P*/ )null);
  }
  public ArgType(Kind k/*= UnknownTy*/, /*const*/char$ptr/*char P*/ n/*= null*/) {
    // : K(k), T(), Name(n), Ptr(false) 
    //START JInit
    this.K = k;
    this.T = new QualType();
    this.Name = $tryClone(n);
    this.Ptr = false;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ArgType::ArgType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 251,
   FQN="clang::analyze_format_string::ArgType::ArgType", NM="_ZN5clang21analyze_format_string7ArgTypeC1ENS_8QualTypeEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string7ArgTypeC1ENS_8QualTypeEPKc")
  //</editor-fold>
  public ArgType(QualType t) {
    this(t, (/*const*/char$ptr/*char P*/ )null);
  }
  public ArgType(QualType t, /*const*/char$ptr/*char P*/ n/*= null*/) {
    // : K(SpecificTy), T(t), Name(n), Ptr(false) 
    //START JInit
    this.K = Kind.SpecificTy;
    this.T = new QualType(t);
    this.Name = $tryClone(n);
    this.Ptr = false;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ArgType::ArgType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 253,
   FQN="clang::analyze_format_string::ArgType::ArgType", NM="_ZN5clang21analyze_format_string7ArgTypeC1ENS_7CanQualINS_4TypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string7ArgTypeC1ENS_7CanQualINS_4TypeEEE")
  //</editor-fold>
  public ArgType(CanQual<Type> t) {
    // : K(SpecificTy), T(t.operator QualType()), Name(null), Ptr(false) 
    //START JInit
    this.K = Kind.SpecificTy;
    this.T = t.$QualType();
    this.Name = null;
    this.Ptr = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ArgType::Invalid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 255,
   FQN="clang::analyze_format_string::ArgType::Invalid", NM="_ZN5clang21analyze_format_string7ArgType7InvalidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string7ArgType7InvalidEv")
  //</editor-fold>
  public static ArgType Invalid() {
    return new ArgType(Kind.InvalidTy);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ArgType::isValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 256,
   FQN="clang::analyze_format_string::ArgType::isValid", NM="_ZNK5clang21analyze_format_string7ArgType7isValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string7ArgType7isValidEv")
  //</editor-fold>
  public boolean isValid() /*const*/ {
    return K != Kind.InvalidTy;
  }

  
  /// Create an ArgType which corresponds to the type pointer to A.
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ArgType::PtrTo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 259,
   FQN="clang::analyze_format_string::ArgType::PtrTo", NM="_ZN5clang21analyze_format_string7ArgType5PtrToERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string7ArgType5PtrToERKS1_")
  //</editor-fold>
  public static ArgType PtrTo(final /*const*/ ArgType /*&*/ A) {
    assert (A.K.getValue() >= Kind.InvalidTy.getValue()) : "ArgType cannot be pointer to invalid/unknown";
    ArgType Res = new ArgType(A);
    Res.Ptr = true;
    return Res;
  }

  
  
  //===----------------------------------------------------------------------===//
  // Methods on ArgType.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ArgType::matchesType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp", line = 290,
   FQN="clang::analyze_format_string::ArgType::matchesType", NM="_ZNK5clang21analyze_format_string7ArgType11matchesTypeERNS_10ASTContextENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string7ArgType11matchesTypeERNS_10ASTContextENS_8QualTypeE")
  //</editor-fold>
  public ArgType.MatchKind matchesType(final ASTContext /*&*/ C, QualType argTy) /*const*/ {
    if (Ptr) {
      // It has to be a pointer.
      /*const*/ PointerType /*P*/ PT = argTy.$arrow().getAs(PointerType.class);
      if (!(PT != null)) {
        return MatchKind.NoMatch;
      }
      
      // We cannot write through a const qualified pointer.
      if (PT.getPointeeType().isConstQualified()) {
        return MatchKind.NoMatch;
      }
      
      argTy.$assignMove(PT.getPointeeType());
    }
    switch (K) {
     case InvalidTy:
      throw new llvm_unreachable("ArgType must be valid");
     case UnknownTy:
      return MatchKind.Match;
     case AnyCharTy:
      {
        {
          /*const*/ EnumType /*P*/ ETy = argTy.$arrow().getAs$EnumType();
          if ((ETy != null)) {
            argTy.$assignMove(ETy.getDecl().getIntegerType());
          }
        }
        {
          
          /*const*/ BuiltinType /*P*/ BT = argTy.$arrow().getAs$BuiltinType();
          if ((BT != null)) {
            switch (BT.getKind()) {
             default:
              break;
             case Char_S:
             case SChar:
             case UChar:
             case Char_U:
              return MatchKind.Match;
            }
          }
        }
        return MatchKind.NoMatch;
      }
     case SpecificTy:
      {
        {
          /*const*/ EnumType /*P*/ ETy = argTy.$arrow().getAs$EnumType();
          if ((ETy != null)) {
            argTy.$assignMove(ETy.getDecl().getIntegerType());
          }
        }
        argTy.$assignMove(C.getCanonicalType(/*NO_COPY*/argTy).getUnqualifiedType().$QualType());
        if (QualType.$eq_QualType$C(T, argTy)) {
          return MatchKind.Match;
        }
        {
          // Check for "compatible types".
          /*const*/ BuiltinType /*P*/ BT = argTy.$arrow().getAs$BuiltinType();
          if ((BT != null)) {
            switch (BT.getKind()) {
             default:
              break;
             case Char_S:
             case SChar:
             case Char_U:
             case UChar:
              return QualType.$eq_QualType$C(T, C.UnsignedCharTy.$QualType()) || QualType.$eq_QualType$C(T, C.SignedCharTy.$QualType()) ? MatchKind.Match : MatchKind.NoMatch;
             case Short:
              return QualType.$eq_QualType$C(T, C.UnsignedShortTy.$QualType()) ? MatchKind.Match : MatchKind.NoMatch;
             case UShort:
              return QualType.$eq_QualType$C(T, C.ShortTy.$QualType()) ? MatchKind.Match : MatchKind.NoMatch;
             case Int:
              return QualType.$eq_QualType$C(T, C.UnsignedIntTy.$QualType()) ? MatchKind.Match : MatchKind.NoMatch;
             case UInt:
              return QualType.$eq_QualType$C(T, C.IntTy.$QualType()) ? MatchKind.Match : MatchKind.NoMatch;
             case Long:
              return QualType.$eq_QualType$C(T, C.UnsignedLongTy.$QualType()) ? MatchKind.Match : MatchKind.NoMatch;
             case ULong:
              return QualType.$eq_QualType$C(T, C.LongTy.$QualType()) ? MatchKind.Match : MatchKind.NoMatch;
             case LongLong:
              return QualType.$eq_QualType$C(T, C.UnsignedLongLongTy.$QualType()) ? MatchKind.Match : MatchKind.NoMatch;
             case ULongLong:
              return QualType.$eq_QualType$C(T, C.LongLongTy.$QualType()) ? MatchKind.Match : MatchKind.NoMatch;
            }
          }
        }
        return MatchKind.NoMatch;
      }
     case CStrTy:
      {
        /*const*/ PointerType /*P*/ PT = argTy.$arrow().getAs(PointerType.class);
        if (!(PT != null)) {
          return MatchKind.NoMatch;
        }
        QualType pointeeTy = PT.getPointeeType();
        {
          /*const*/ BuiltinType /*P*/ BT = pointeeTy.$arrow().getAs$BuiltinType();
          if ((BT != null)) {
            switch (BT.getKind()) {
             case Void:
             case Char_U:
             case UChar:
             case Char_S:
             case SChar:
              return MatchKind.Match;
             default:
              break;
            }
          }
        }
        
        return MatchKind.NoMatch;
      }
     case WCStrTy:
      {
        /*const*/ PointerType /*P*/ PT = argTy.$arrow().getAs(PointerType.class);
        if (!(PT != null)) {
          return MatchKind.NoMatch;
        }
        QualType pointeeTy = C.getCanonicalType(PT.getPointeeType()).getUnqualifiedType().$QualType();
        return QualType.$eq_QualType$C(pointeeTy, C.getWideCharType()) ? MatchKind.Match : MatchKind.NoMatch;
      }
     case WIntTy:
      {
        
        QualType PromoArg = argTy.$arrow().isPromotableIntegerType() ? C.getPromotedIntegerType(new QualType(argTy)) : new QualType(argTy);
        
        QualType WInt = C.getCanonicalType(C.getWIntType()).getUnqualifiedType().$QualType();
        PromoArg.$assignMove(C.getCanonicalType(/*NO_COPY*/PromoArg).getUnqualifiedType().$QualType());
        
        // If the promoted argument is the corresponding signed type of the
        // wint_t type, then it should match.
        if (PromoArg.$arrow().hasSignedIntegerRepresentation()
           && QualType.$eq_QualType$C(C.getCorrespondingUnsignedType(new QualType(PromoArg)), WInt)) {
          return MatchKind.Match;
        }
        
        return QualType.$eq_QualType$C(WInt, PromoArg) ? MatchKind.Match : MatchKind.NoMatch;
      }
     case CPointerTy:
      if (argTy.$arrow().isVoidPointerType()) {
        return MatchKind.Match;
      }
      if (argTy.$arrow().isPointerType() || argTy.$arrow().isObjCObjectPointerType()
         || argTy.$arrow().isBlockPointerType() || argTy.$arrow().isNullPtrType()) {
        return MatchKind.NoMatchPedantic;
      } else {
        return MatchKind.NoMatch;
      }
     case ObjCPointerTy:
      {
        if ((argTy.$arrow().getAs(ObjCObjectPointerType.class) != null)
           || (argTy.$arrow().getAs(BlockPointerType.class) != null)) {
          return MatchKind.Match;
        }
        {
          
          // Handle implicit toll-free bridging.
          /*const*/ PointerType /*P*/ PT = argTy.$arrow().getAs(PointerType.class);
          if ((PT != null)) {
            // Things such as CFTypeRef are really just opaque pointers
            // to C structs representing CF types that can often be bridged
            // to Objective-C objects.  Since the compiler doesn't know which
            // structs can be toll-free bridged, we just accept them all.
            QualType pointee = PT.getPointeeType();
            if ((pointee.$arrow().getAsStructureType() != null) || pointee.$arrow().isVoidType()) {
              return MatchKind.Match;
            }
          }
        }
        return MatchKind.NoMatch;
      }
    }
    throw new llvm_unreachable("Invalid ArgType Kind!");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ArgType::getRepresentativeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp", line = 446,
   FQN="clang::analyze_format_string::ArgType::getRepresentativeType", NM="_ZNK5clang21analyze_format_string7ArgType21getRepresentativeTypeERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string7ArgType21getRepresentativeTypeERNS_10ASTContextE")
  //</editor-fold>
  public QualType getRepresentativeType(final ASTContext /*&*/ C) /*const*/ {
    QualType Res/*J*/= new QualType();
    switch (K) {
     case InvalidTy:
      throw new llvm_unreachable("No representative type for Invalid ArgType");
     case UnknownTy:
      throw new llvm_unreachable("No representative type for Unknown ArgType");
     case AnyCharTy:
      Res.$assignMove(C.CharTy.$QualType());
      break;
     case SpecificTy:
      Res.$assign(T);
      break;
     case CStrTy:
      Res.$assignMove(C.getPointerType(/*NO_COPY*/C.CharTy).$QualType());
      break;
     case WCStrTy:
      Res.$assignMove(C.getPointerType(C.getWideCharType()));
      break;
     case ObjCPointerTy:
      Res.$assignMove(C.ObjCBuiltinIdTy.$QualType());
      break;
     case CPointerTy:
      Res.$assignMove(C.VoidPtrTy.$QualType());
      break;
     case WIntTy:
      {
        Res.$assignMove(C.getWIntType());
        break;
      }
    }
    if (Ptr) {
      Res.$assignMove(C.getPointerType(/*NO_COPY*/Res));
    }
    return Res;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ArgType::getRepresentativeTypeName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp", line = 482,
   FQN="clang::analyze_format_string::ArgType::getRepresentativeTypeName", NM="_ZNK5clang21analyze_format_string7ArgType25getRepresentativeTypeNameERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string7ArgType25getRepresentativeTypeNameERNS_10ASTContextE")
  //</editor-fold>
  public std.string getRepresentativeTypeName(final ASTContext /*&*/ C) /*const*/ {
    std.string S = getRepresentativeType(C).getAsString();
    
    std.string Alias/*J*/= new std.string();
    if (Native.$bool(Name)) {
      // Use a specific name for this type, e.g. "size_t".
      Alias.$assign_T$C$P(Name);
      if (Ptr) {
        // If ArgType is actually a pointer to T, append an asterisk.
        Alias.$addassign_T$C$P((Alias.$at(Alias.size() - 1) == $$STAR) ? $STAR : $(" *"));
      }
      // If Alias is the same as the underlying type, e.g. wchar_t, then drop it.
      if ($eq_str$C(S, Alias)) {
        Alias.clear();
      }
    }
    if (!Alias.empty()) {
      return $add_string_T$C$P($add_string_string$C($add_string_T$C$P($add_string_string$C(new std.string(/*KEEP_STR*/$SGL_QUOTE), Alias), /*KEEP_STR*/"' (aka '"), S), /*KEEP_STR*/"')");
    }
    return $add_string_T$C$P($add_string_string$C(new std.string(/*KEEP_STR*/$SGL_QUOTE), S), /*KEEP_STR*/"'");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ArgType::ArgType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 236,
   FQN="clang::analyze_format_string::ArgType::ArgType", NM="_ZN5clang21analyze_format_string7ArgTypeC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string7ArgTypeC1ERKS1_")
  //</editor-fold>
  public /*inline*/ ArgType(final /*const*/ ArgType /*&*/ $Prm0) {
    // : K(.K), T(.T), Name(.Name), Ptr(.Ptr) 
    //START JInit
    this.K = $Prm0.K;
    this.T = new QualType($Prm0.T);
    this.Name = $tryClone($Prm0.Name);
    this.Ptr = $Prm0.Ptr;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ArgType::ArgType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 236,
   FQN="clang::analyze_format_string::ArgType::ArgType", NM="_ZN5clang21analyze_format_string7ArgTypeC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string7ArgTypeC1EOS1_")
  //</editor-fold>
  public /*inline*/ ArgType(JD$Move _dparam, final ArgType /*&&*/$Prm0) {
    // : K(static_cast<ArgType &&>().K), T(static_cast<ArgType &&>().T), Name(static_cast<ArgType &&>().Name), Ptr(static_cast<ArgType &&>().Ptr) 
    //START JInit
    this.K = $Prm0.K;
    this.T = new QualType(JD$Move.INSTANCE, $Prm0.T);
    this.Name = $tryClone($Prm0.Name);
    this.Ptr = $Prm0.Ptr;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "K=" + K // NOI18N
              + ", T=" + T // NOI18N
              + ", Name=" + Name // NOI18N
              + ", Ptr=" + Ptr; // NOI18N
  }
}
