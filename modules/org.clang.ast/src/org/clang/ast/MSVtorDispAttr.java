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
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::MSVtorDispAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3427,
 FQN="clang::MSVtorDispAttr", NM="_ZN5clang14MSVtorDispAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang14MSVtorDispAttrE")
//</editor-fold>
public class MSVtorDispAttr extends /*public*/ InheritableAttr {
  private /*uint*/int vdm;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::MSVtorDispAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3431,
   FQN="clang::MSVtorDispAttr::CreateImplicit", NM="_ZN5clang14MSVtorDispAttr14CreateImplicitERNS_10ASTContextEjNS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang14MSVtorDispAttr14CreateImplicitERNS_10ASTContextEjNS_11SourceRangeE")
  //</editor-fold>
  public static MSVtorDispAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, /*uint*/int Vdm) {
    return CreateImplicit(Ctx, Vdm, new SourceRange());
  }
  public static MSVtorDispAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, /*uint*/int Vdm, SourceRange Loc/*= SourceRange()*/) {
    MSVtorDispAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new MSVtorDispAttr(new SourceRange(Loc), Ctx, Vdm, 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSVtorDispAttr::MSVtorDispAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3437,
   FQN="clang::MSVtorDispAttr::MSVtorDispAttr", NM="_ZN5clang14MSVtorDispAttrC1ENS_11SourceRangeERNS_10ASTContextEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang14MSVtorDispAttrC1ENS_11SourceRangeERNS_10ASTContextEjj")
  //</editor-fold>
  public MSVtorDispAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      /*uint*/int Vdm, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::MSVtorDisp, R, SI, false, false), vdm(Vdm) 
    //START JInit
    super(attr.Kind.MSVtorDisp, new SourceRange(R), SI, false, false);
    this.vdm = Vdm;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSVtorDispAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 3118,
   FQN="clang::MSVtorDispAttr::clone", NM="_ZNK5clang14MSVtorDispAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14MSVtorDispAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public MSVtorDispAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    MSVtorDispAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new MSVtorDispAttr(new SourceRange(getLocation()), C, vdm, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MSVtorDispAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 3126,
   FQN="clang::MSVtorDispAttr::printPretty", NM="_ZNK5clang14MSVtorDispAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14MSVtorDispAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MSVtorDispAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 3129,
   FQN="clang::MSVtorDispAttr::getSpelling", NM="_ZNK5clang14MSVtorDispAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14MSVtorDispAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    return $("(No spelling)");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MSVtorDispAttr::getVdm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3450,
   FQN="clang::MSVtorDispAttr::getVdm", NM="_ZNK5clang14MSVtorDispAttr6getVdmEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14MSVtorDispAttr6getVdmEv")
  //</editor-fold>
  public /*uint*/int getVdm() /*const*/ {
    return vdm;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSVtorDispAttr::Mode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3455,
   FQN="clang::MSVtorDispAttr::Mode", NM="_ZN5clang14MSVtorDispAttr4ModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang14MSVtorDispAttr4ModeE")
  //</editor-fold>
  public enum Mode implements Native.ComparableLower {
    Never(0),
    ForVBaseOverride(Never.getValue() + 1),
    ForVFTable(ForVBaseOverride.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Mode valueOf(int val) {
      Mode out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Mode[] VALUES;
      private static final Mode[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Mode kind : Mode.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Mode[min < 0 ? (1-min) : 0];
        VALUES = new Mode[max >= 0 ? (1+max) : 0];
        for (Mode kind : Mode.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Mode(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Mode)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Mode)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::MSVtorDispAttr::getVtorDispMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3461,
   FQN="clang::MSVtorDispAttr::getVtorDispMode", NM="_ZNK5clang14MSVtorDispAttr15getVtorDispModeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14MSVtorDispAttr15getVtorDispModeEv")
  //</editor-fold>
  public Mode getVtorDispMode() /*const*/ {
    return Mode.valueOf(vdm);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSVtorDispAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3464,
   FQN="clang::MSVtorDispAttr::classof", NM="_ZN5clang14MSVtorDispAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang14MSVtorDispAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.MSVtorDisp;
  }

  
  @Override public String toString() {
    return "" + "vdm=" + vdm // NOI18N
              + super.toString(); // NOI18N
  }
}
