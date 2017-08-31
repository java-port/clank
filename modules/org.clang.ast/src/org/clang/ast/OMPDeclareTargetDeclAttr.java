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

package org.clang.ast;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareTargetDeclAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4465,
 FQN="clang::OMPDeclareTargetDeclAttr", NM="_ZN5clang24OMPDeclareTargetDeclAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang24OMPDeclareTargetDeclAttrE")
//</editor-fold>
public class OMPDeclareTargetDeclAttr extends /*public*/ Attr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareTargetDeclAttr::MapTypeTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4467,
   FQN="clang::OMPDeclareTargetDeclAttr::MapTypeTy", NM="_ZN5clang24OMPDeclareTargetDeclAttr9MapTypeTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang24OMPDeclareTargetDeclAttr9MapTypeTyE")
  //</editor-fold>
  public enum MapTypeTy implements Native.ComparableLower {
    MT_To(0),
    MT_Link(MT_To.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static MapTypeTy valueOf(int val) {
      MapTypeTy out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final MapTypeTy[] VALUES;
      private static final MapTypeTy[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (MapTypeTy kind : MapTypeTy.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new MapTypeTy[min < 0 ? (1-min) : 0];
        VALUES = new MapTypeTy[max >= 0 ? (1+max) : 0];
        for (MapTypeTy kind : MapTypeTy.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private MapTypeTy(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((MapTypeTy)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((MapTypeTy)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private MapTypeTy mapType;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareTargetDeclAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4475,
   FQN="clang::OMPDeclareTargetDeclAttr::CreateImplicit", NM="_ZN5clang24OMPDeclareTargetDeclAttr14CreateImplicitERNS_10ASTContextENS0_9MapTypeTyENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang24OMPDeclareTargetDeclAttr14CreateImplicitERNS_10ASTContextENS0_9MapTypeTyENS_11SourceRangeE")
  //</editor-fold>
  public static OMPDeclareTargetDeclAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, MapTypeTy MapType) {
    return CreateImplicit(Ctx, MapType, new SourceRange());
  }
  public static OMPDeclareTargetDeclAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, MapTypeTy MapType, SourceRange Loc/*= SourceRange()*/) {
    OMPDeclareTargetDeclAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new OMPDeclareTargetDeclAttr(new SourceRange(Loc), Ctx, MapType, 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareTargetDeclAttr::OMPDeclareTargetDeclAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4481,
   FQN="clang::OMPDeclareTargetDeclAttr::OMPDeclareTargetDeclAttr", NM="_ZN5clang24OMPDeclareTargetDeclAttrC1ENS_11SourceRangeERNS_10ASTContextENS0_9MapTypeTyEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang24OMPDeclareTargetDeclAttrC1ENS_11SourceRangeERNS_10ASTContextENS0_9MapTypeTyEj")
  //</editor-fold>
  public OMPDeclareTargetDeclAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      MapTypeTy MapType, 
      /*uint*/int SI) {
    // : Attr(attr::OMPDeclareTargetDecl, R, SI, false, false), mapType(MapType) 
    //START JInit
    super(attr.Kind.OMPDeclareTargetDecl, new SourceRange(R), SI, false, false);
    this.mapType = MapType;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareTargetDeclAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 4092,
   FQN="clang::OMPDeclareTargetDeclAttr::clone", NM="_ZNK5clang24OMPDeclareTargetDeclAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang24OMPDeclareTargetDeclAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public OMPDeclareTargetDeclAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    OMPDeclareTargetDeclAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new OMPDeclareTargetDeclAttr(new SourceRange(getLocation()), C, mapType, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareTargetDeclAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 4100,
   FQN="clang::OMPDeclareTargetDeclAttr::printPretty", NM="_ZNK5clang24OMPDeclareTargetDeclAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang24OMPDeclareTargetDeclAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/"#pragma omp declare target ");
        printPrettyPragma(OS, Policy);
        OS.$out(/*KEEP_STR*/$LF);
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareTargetDeclAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 4113,
   FQN="clang::OMPDeclareTargetDeclAttr::getSpelling", NM="_ZNK5clang24OMPDeclareTargetDeclAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang24OMPDeclareTargetDeclAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("declare target");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareTargetDeclAttr::getMapType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4494,
   FQN="clang::OMPDeclareTargetDeclAttr::getMapType", NM="_ZNK5clang24OMPDeclareTargetDeclAttr10getMapTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang24OMPDeclareTargetDeclAttr10getMapTypeEv")
  //</editor-fold>
  public MapTypeTy getMapType() /*const*/ {
    return mapType;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareTargetDeclAttr::ConvertStrToMapTypeTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4498,
   FQN="clang::OMPDeclareTargetDeclAttr::ConvertStrToMapTypeTy", NM="_ZN5clang24OMPDeclareTargetDeclAttr21ConvertStrToMapTypeTyEN4llvm9StringRefERNS0_9MapTypeTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang24OMPDeclareTargetDeclAttr21ConvertStrToMapTypeTyEN4llvm9StringRefERNS0_9MapTypeTyE")
  //</editor-fold>
  public static boolean ConvertStrToMapTypeTy(StringRef Val, final type$ref<MapTypeTy /*&*/> Out) {
    Optional<MapTypeTy> R = new StringSwitch<Optional<MapTypeTy> >(/*NO_COPY*/Val).
        Case(/*KEEP_STR*/"to", new Optional<MapTypeTy>(JD$T$RR.INSTANCE, OMPDeclareTargetDeclAttr.MapTypeTy.MT_To)).
        Case(/*KEEP_STR*/"link", new Optional<MapTypeTy>(JD$T$RR.INSTANCE, OMPDeclareTargetDeclAttr.MapTypeTy.MT_Link)).
        Default(new Optional<MapTypeTy>());
    if (R.$bool()) {
      Out.$set(R.$star());
      return true;
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareTargetDeclAttr::ConvertMapTypeTyToStr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4510,
   FQN="clang::OMPDeclareTargetDeclAttr::ConvertMapTypeTyToStr", NM="_ZN5clang24OMPDeclareTargetDeclAttr21ConvertMapTypeTyToStrENS0_9MapTypeTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang24OMPDeclareTargetDeclAttr21ConvertMapTypeTyToStrENS0_9MapTypeTyE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ ConvertMapTypeTyToStr(MapTypeTy Val) {
    switch (Val) {
     case MT_To:
      return $("to");
     case MT_Link:
      return $("link");
    }
    throw new llvm_unreachable("No enumerator with that value");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareTargetDeclAttr::printPrettyPragma">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4518,
   FQN="clang::OMPDeclareTargetDeclAttr::printPrettyPragma", NM="_ZNK5clang24OMPDeclareTargetDeclAttr17printPrettyPragmaERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang24OMPDeclareTargetDeclAttr17printPrettyPragmaERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPrettyPragma(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    // Use fake syntax because it is for testing and debugging purpose only.
    if (getMapType() != MapTypeTy.MT_To) {
      OS.$out(ConvertMapTypeTyToStr(getMapType())).$out(/*KEEP_STR*/$SPACE);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDeclareTargetDeclAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4525,
   FQN="clang::OMPDeclareTargetDeclAttr::classof", NM="_ZN5clang24OMPDeclareTargetDeclAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang24OMPDeclareTargetDeclAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.OMPDeclareTargetDecl;
  }

  
  @Override public String toString() {
    return "" + "mapType=" + mapType // NOI18N
              + super.toString(); // NOI18N
  }
}
