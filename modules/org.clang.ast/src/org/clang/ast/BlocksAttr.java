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

//<editor-fold defaultstate="collapsed" desc="clang::BlocksAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1138,
 FQN="clang::BlocksAttr", NM="_ZN5clang10BlocksAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang10BlocksAttrE")
//</editor-fold>
public class BlocksAttr extends /*public*/ InheritableAttr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::BlocksAttr::BlockType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1140,
   FQN="clang::BlocksAttr::BlockType", NM="_ZN5clang10BlocksAttr9BlockTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang10BlocksAttr9BlockTypeE")
  //</editor-fold>
  public enum BlockType implements Native.ComparableLower {
    ByRef(0);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static BlockType valueOf(int val) {
      BlockType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final BlockType[] VALUES;
      private static final BlockType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (BlockType kind : BlockType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new BlockType[min < 0 ? (1-min) : 0];
        VALUES = new BlockType[max >= 0 ? (1+max) : 0];
        for (BlockType kind : BlockType.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private BlockType(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((BlockType)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((BlockType)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private BlockType type;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::BlocksAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1147,
   FQN="clang::BlocksAttr::CreateImplicit", NM="_ZN5clang10BlocksAttr14CreateImplicitERNS_10ASTContextENS0_9BlockTypeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang10BlocksAttr14CreateImplicitERNS_10ASTContextENS0_9BlockTypeENS_11SourceRangeE")
  //</editor-fold>
  public static BlocksAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, BlockType Type) {
    return CreateImplicit(Ctx, Type, new SourceRange());
  }
  public static BlocksAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, BlockType Type, SourceRange Loc/*= SourceRange()*/) {
    BlocksAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new BlocksAttr(new SourceRange(Loc), Ctx, Type, 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BlocksAttr::BlocksAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1153,
   FQN="clang::BlocksAttr::BlocksAttr", NM="_ZN5clang10BlocksAttrC1ENS_11SourceRangeERNS_10ASTContextENS0_9BlockTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang10BlocksAttrC1ENS_11SourceRangeERNS_10ASTContextENS0_9BlockTypeEj")
  //</editor-fold>
  public BlocksAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      BlockType Type, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::Blocks, R, SI, false, false), type(Type) 
    //START JInit
    super(attr.Kind.Blocks, new SourceRange(R), SI, false, false);
    this.type = Type;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BlocksAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 916,
   FQN="clang::BlocksAttr::clone", NM="_ZNK5clang10BlocksAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang10BlocksAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public BlocksAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    BlocksAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new BlocksAttr(new SourceRange(getLocation()), C, type, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BlocksAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 924,
   FQN="clang::BlocksAttr::printPretty", NM="_ZNK5clang10BlocksAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang10BlocksAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((blocks(\"").$out(BlocksAttr.ConvertBlockTypeToStr(getType())).$out(/*KEEP_STR*/"\")))");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BlocksAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 936,
   FQN="clang::BlocksAttr::getSpelling", NM="_ZNK5clang10BlocksAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang10BlocksAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("blocks");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BlocksAttr::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1166,
   FQN="clang::BlocksAttr::getType", NM="_ZNK5clang10BlocksAttr7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang10BlocksAttr7getTypeEv")
  //</editor-fold>
  public BlockType getType() /*const*/ {
    return type;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BlocksAttr::ConvertStrToBlockType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1170,
   FQN="clang::BlocksAttr::ConvertStrToBlockType", NM="_ZN5clang10BlocksAttr21ConvertStrToBlockTypeEN4llvm9StringRefERNS0_9BlockTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang10BlocksAttr21ConvertStrToBlockTypeEN4llvm9StringRefERNS0_9BlockTypeE")
  //</editor-fold>
  public static boolean ConvertStrToBlockType(StringRef Val, final type$ref<BlockType /*&*/> Out) {
    Optional<BlockType> R = new StringSwitch<Optional<BlockType> >(/*NO_COPY*/Val).
        Case(/*KEEP_STR*/"byref", new Optional<BlockType>(JD$T$RR.INSTANCE, BlocksAttr.BlockType.ByRef)).
        Default(new Optional<BlockType>());
    if (R.$bool()) {
      Out.$set(R.$star());
      return true;
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BlocksAttr::ConvertBlockTypeToStr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1181,
   FQN="clang::BlocksAttr::ConvertBlockTypeToStr", NM="_ZN5clang10BlocksAttr21ConvertBlockTypeToStrENS0_9BlockTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang10BlocksAttr21ConvertBlockTypeToStrENS0_9BlockTypeE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ ConvertBlockTypeToStr(BlockType Val) {
    switch (Val) {
     case ByRef:
      return $("byref");
    }
    throw new llvm_unreachable("No enumerator with that value");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BlocksAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1189,
   FQN="clang::BlocksAttr::classof", NM="_ZN5clang10BlocksAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang10BlocksAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.Blocks;
  }

  
  @Override public String toString() {
    return "" + "type=" + type // NOI18N
              + super.toString(); // NOI18N
  }
}
