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
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::OpenCLAccessAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5076,
 FQN="clang::OpenCLAccessAttr", NM="_ZN5clang16OpenCLAccessAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16OpenCLAccessAttrE")
//</editor-fold>
public class OpenCLAccessAttr extends /*public*/ Attr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLAccessAttr::Spelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5078,
   FQN="clang::OpenCLAccessAttr::Spelling", NM="_ZN5clang16OpenCLAccessAttr8SpellingE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16OpenCLAccessAttr8SpellingE")
  //</editor-fold>
  public enum Spelling implements Native.ComparableLower {
    Keyword_read_only(0),
    Keyword_write_only(2),
    Keyword_read_write(4);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Spelling valueOf(int val) {
      Spelling out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Spelling[] VALUES;
      private static final Spelling[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Spelling kind : Spelling.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Spelling[min < 0 ? (1-min) : 0];
        VALUES = new Spelling[max >= 0 ? (1+max) : 0];
        for (Spelling kind : Spelling.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Spelling(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Spelling)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Spelling)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLAccessAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5084,
   FQN="clang::OpenCLAccessAttr::CreateImplicit", NM="_ZN5clang16OpenCLAccessAttr14CreateImplicitERNS_10ASTContextENS0_8SpellingENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16OpenCLAccessAttr14CreateImplicitERNS_10ASTContextENS0_8SpellingENS_11SourceRangeE")
  //</editor-fold>
  public static OpenCLAccessAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, Spelling S) {
    return CreateImplicit(Ctx, S, new SourceRange());
  }
  public static OpenCLAccessAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, Spelling S, SourceRange Loc/*= SourceRange()*/) {
    OpenCLAccessAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new OpenCLAccessAttr(new SourceRange(Loc), Ctx, S.getValue());
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLAccessAttr::OpenCLAccessAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5090,
   FQN="clang::OpenCLAccessAttr::OpenCLAccessAttr", NM="_ZN5clang16OpenCLAccessAttrC1ENS_11SourceRangeERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16OpenCLAccessAttrC1ENS_11SourceRangeERNS_10ASTContextEj")
  //</editor-fold>
  public OpenCLAccessAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      /*uint*/int SI) {
    // : Attr(attr::OpenCLAccess, R, SI, false, false) 
    //START JInit
    super(attr.Kind.OpenCLAccess, new SourceRange(R), SI, false, false);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLAccessAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 4648,
   FQN="clang::OpenCLAccessAttr::clone", NM="_ZNK5clang16OpenCLAccessAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16OpenCLAccessAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public OpenCLAccessAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    OpenCLAccessAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new OpenCLAccessAttr(new SourceRange(getLocation()), C, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLAccessAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 4656,
   FQN="clang::OpenCLAccessAttr::printPretty", NM="_ZNK5clang16OpenCLAccessAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16OpenCLAccessAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __read_only");
        break;
      }
     case 1:
      {
        OS.$out(/*KEEP_STR*/" read_only");
        break;
      }
     case 2:
      {
        OS.$out(/*KEEP_STR*/" __write_only");
        break;
      }
     case 3:
      {
        OS.$out(/*KEEP_STR*/" write_only");
        break;
      }
     case 4:
      {
        OS.$out(/*KEEP_STR*/" __read_write");
        break;
      }
     case 5:
      {
        OS.$out(/*KEEP_STR*/" read_write");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLAccessAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 4688,
   FQN="clang::OpenCLAccessAttr::getSpelling", NM="_ZNK5clang16OpenCLAccessAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16OpenCLAccessAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $__read_only;
     case 1:
      return $read_only;
     case 2:
      return $__write_only;
     case 3:
      return $write_only;
     case 4:
      return $__read_write;
     case 5:
      return $read_write;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLAccessAttr::getSemanticSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5101,
   FQN="clang::OpenCLAccessAttr::getSemanticSpelling", NM="_ZNK5clang16OpenCLAccessAttr19getSemanticSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16OpenCLAccessAttr19getSemanticSpellingEv")
  //</editor-fold>
  public Spelling getSemanticSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown spelling list index");
     case 0:
      return Spelling.Keyword_read_only;
     case 1:
      return Spelling.Keyword_read_only;
     case 2:
      return Spelling.Keyword_write_only;
     case 3:
      return Spelling.Keyword_write_only;
     case 4:
      return Spelling.Keyword_read_write;
     case 5:
      return Spelling.Keyword_read_write;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLAccessAttr::isReadOnly">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5112,
   FQN="clang::OpenCLAccessAttr::isReadOnly", NM="_ZNK5clang16OpenCLAccessAttr10isReadOnlyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16OpenCLAccessAttr10isReadOnlyEv")
  //</editor-fold>
  public boolean isReadOnly() /*const*/ {
    return SpellingListIndex == $int2uint_4bits(0)
       || SpellingListIndex == $int2uint_4bits(1);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLAccessAttr::isReadWrite">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5114,
   FQN="clang::OpenCLAccessAttr::isReadWrite", NM="_ZNK5clang16OpenCLAccessAttr11isReadWriteEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16OpenCLAccessAttr11isReadWriteEv")
  //</editor-fold>
  public boolean isReadWrite() /*const*/ {
    return SpellingListIndex == $int2uint_4bits(4)
       || SpellingListIndex == $int2uint_4bits(5);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLAccessAttr::isWriteOnly">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5116,
   FQN="clang::OpenCLAccessAttr::isWriteOnly", NM="_ZNK5clang16OpenCLAccessAttr11isWriteOnlyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16OpenCLAccessAttr11isWriteOnlyEv")
  //</editor-fold>
  public boolean isWriteOnly() /*const*/ {
    return SpellingListIndex == $int2uint_4bits(2)
       || SpellingListIndex == $int2uint_4bits(3);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLAccessAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5120,
   FQN="clang::OpenCLAccessAttr::classof", NM="_ZN5clang16OpenCLAccessAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16OpenCLAccessAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.OpenCLAccess;
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
