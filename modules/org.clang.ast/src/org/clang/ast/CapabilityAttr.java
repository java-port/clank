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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::CapabilityAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1651,
 FQN="clang::CapabilityAttr", NM="_ZN5clang14CapabilityAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang14CapabilityAttrE")
//</editor-fold>
public class CapabilityAttr extends /*public*/ InheritableAttr {
  private /*uint*/int nameLength;
  private char$ptr/*char P*/ name;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CapabilityAttr::Spelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1656,
   FQN="clang::CapabilityAttr::Spelling", NM="_ZN5clang14CapabilityAttr8SpellingE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang14CapabilityAttr8SpellingE")
  //</editor-fold>
  public enum Spelling implements Native.ComparableLower {
    GNU_capability(0),
    CXX11_clang_capability(1),
    GNU_shared_capability(2),
    CXX11_clang_shared_capability(3);

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
  
  //<editor-fold defaultstate="collapsed" desc="clang::CapabilityAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1663,
   FQN="clang::CapabilityAttr::CreateImplicit", NM="_ZN5clang14CapabilityAttr14CreateImplicitERNS_10ASTContextENS0_8SpellingEN4llvm9StringRefENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang14CapabilityAttr14CreateImplicitERNS_10ASTContextENS0_8SpellingEN4llvm9StringRefENS_11SourceRangeE")
  //</editor-fold>
  public static CapabilityAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, Spelling S, StringRef Name) {
    return CreateImplicit(Ctx, S, Name, new SourceRange());
  }
  public static CapabilityAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, Spelling S, StringRef Name, SourceRange Loc/*= SourceRange()*/) {
    CapabilityAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new CapabilityAttr(new SourceRange(Loc), Ctx, new StringRef(Name), S.getValue());
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CapabilityAttr::CapabilityAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1669,
   FQN="clang::CapabilityAttr::CapabilityAttr", NM="_ZN5clang14CapabilityAttrC1ENS_11SourceRangeERNS_10ASTContextEN4llvm9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang14CapabilityAttrC1ENS_11SourceRangeERNS_10ASTContextEN4llvm9StringRefEj")
  //</editor-fold>
  public CapabilityAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      StringRef Name, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::Capability, R, SI, false, false), nameLength(Name.size()), name(new (Ctx, 1) new char [nameLength]) 
    //START JInit
    super(attr.Kind.Capability, new SourceRange(R), SI, false, false);
    this.nameLength = Name.size();
    this.name = create_char$ptr(/*FIXME:NEW_EXPR*//*new (Ctx, 1)*/ new$char(nameLength));
    //END JInit
    if (!Name.empty()) {
      std.memcpy(name, Name.data(), nameLength);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CapabilityAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 1436,
   FQN="clang::CapabilityAttr::clone", NM="_ZNK5clang14CapabilityAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14CapabilityAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public CapabilityAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    CapabilityAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new CapabilityAttr(new SourceRange(getLocation()), C, getName(), getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CapabilityAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 1444,
   FQN="clang::CapabilityAttr::printPretty", NM="_ZNK5clang14CapabilityAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14CapabilityAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((capability(\"").$out(getName()).$out(/*KEEP_STR*/"\")))");
        break;
      }
     case 1:
      {
        OS.$out(/*KEEP_STR*/" [[clang::capability(\"").$out(getName()).$out(/*KEEP_STR*/"\")]]");
        break;
      }
     case 2:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((shared_capability(\"").$out(getName()).$out(/*KEEP_STR*/"\")))");
        break;
      }
     case 3:
      {
        OS.$out(/*KEEP_STR*/" [[clang::shared_capability(\"").$out(getName()).$out(/*KEEP_STR*/"\")]]");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CapabilityAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 1468,
   FQN="clang::CapabilityAttr::getSpelling", NM="_ZNK5clang14CapabilityAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14CapabilityAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("capability");
     case 1:
      return $("capability");
     case 2:
      return $("shared_capability");
     case 3:
      return $("shared_capability");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CapabilityAttr::getSemanticSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1684,
   FQN="clang::CapabilityAttr::getSemanticSpelling", NM="_ZNK5clang14CapabilityAttr19getSemanticSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14CapabilityAttr19getSemanticSpellingEv")
  //</editor-fold>
  public Spelling getSemanticSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown spelling list index");
     case 0:
      return Spelling.GNU_capability;
     case 1:
      return Spelling.CXX11_clang_capability;
     case 2:
      return Spelling.GNU_shared_capability;
     case 3:
      return Spelling.CXX11_clang_shared_capability;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CapabilityAttr::isShared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1693,
   FQN="clang::CapabilityAttr::isShared", NM="_ZNK5clang14CapabilityAttr8isSharedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14CapabilityAttr8isSharedEv")
  //</editor-fold>
  public boolean isShared() /*const*/ {
    return SpellingListIndex == $int2uint_4bits(2)
       || SpellingListIndex == $int2uint_4bits(3);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CapabilityAttr::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1695,
   FQN="clang::CapabilityAttr::getName", NM="_ZNK5clang14CapabilityAttr7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14CapabilityAttr7getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    return new StringRef(name, nameLength);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CapabilityAttr::getNameLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1698,
   FQN="clang::CapabilityAttr::getNameLength", NM="_ZNK5clang14CapabilityAttr13getNameLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14CapabilityAttr13getNameLengthEv")
  //</editor-fold>
  public /*uint*/int getNameLength() /*const*/ {
    return nameLength;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CapabilityAttr::setName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1701,
   FQN="clang::CapabilityAttr::setName", NM="_ZN5clang14CapabilityAttr7setNameERNS_10ASTContextEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang14CapabilityAttr7setNameERNS_10ASTContextEN4llvm9StringRefE")
  //</editor-fold>
  public void setName(final ASTContext /*&*/ C, StringRef S) {
    nameLength = S.size();
    this.name = create_char$ptr(/*FIXME:NEW_EXPR*//*new (C, 1)*/ new$char(nameLength));
    if (!S.empty()) {
      std.memcpy(this.name, S.data(), nameLength);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CapabilityAttr::isMutex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1709,
   FQN="clang::CapabilityAttr::isMutex", NM="_ZNK5clang14CapabilityAttr7isMutexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14CapabilityAttr7isMutexEv")
  //</editor-fold>
  public boolean isMutex() /*const*/ {
    return getName().equals_lower(/*STRINGREF_STR*/"mutex");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CapabilityAttr::isRole">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1710,
   FQN="clang::CapabilityAttr::isRole", NM="_ZNK5clang14CapabilityAttr6isRoleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14CapabilityAttr6isRoleEv")
  //</editor-fold>
  public boolean isRole() /*const*/ {
    return getName().equals_lower(/*STRINGREF_STR*/"role");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CapabilityAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1713,
   FQN="clang::CapabilityAttr::classof", NM="_ZN5clang14CapabilityAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang14CapabilityAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.Capability;
  }

  
  @Override public String toString() {
    return "" + "nameLength=" + nameLength // NOI18N
              + ", name=" + name // NOI18N
              + super.toString(); // NOI18N
  }
}
