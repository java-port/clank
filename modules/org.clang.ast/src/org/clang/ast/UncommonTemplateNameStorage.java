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
import static org.clank.support.Casts.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;


/// \brief Implementation class used to describe either a set of overloaded
/// template names or an already-substituted template template parameter pack.
//<editor-fold defaultstate="collapsed" desc="clang::UncommonTemplateNameStorage">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 42,
 FQN="clang::UncommonTemplateNameStorage", NM="_ZN5clang27UncommonTemplateNameStorageE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang27UncommonTemplateNameStorageE")
//</editor-fold>
public class UncommonTemplateNameStorage extends FoldingSetImpl.ContextualNodeImpl<ASTContext> {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::UncommonTemplateNameStorage::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 44,
   FQN="clang::UncommonTemplateNameStorage::Kind", NM="_ZN5clang27UncommonTemplateNameStorage4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang27UncommonTemplateNameStorage4KindE")
  //</editor-fold>
  protected enum Kind implements Native.ComparableLower {
    Overloaded(0),
    SubstTemplateTemplateParm(Overloaded.getValue() + 1),
    SubstTemplateTemplateParmPack(SubstTemplateTemplateParm.getValue() + 1);

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
  
  //<editor-fold defaultstate="collapsed" desc="clang::UncommonTemplateNameStorage::BitsTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 50,
   FQN="clang::UncommonTemplateNameStorage::BitsTag", NM="_ZN5clang27UncommonTemplateNameStorage7BitsTagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang27UncommonTemplateNameStorage7BitsTagE")
  //</editor-fold>
  protected static class/*struct*/ BitsTag {
    /// \brief A Kind.
    public /*JBYTE unsigned int*/ byte Kind /*: 2*/;
    
    /// \brief The number of stored templates or template arguments,
    /// depending on which subclass we have.
    public /*uint*/int Size /*: 30*/;
    
    @Override public String toString() {
      return "" + "Kind=" + $uchar2uint(Kind) // NOI18N
                + ", Size=" + Size; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::UncommonTemplateNameStorage::(anonymous)">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Init*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 59,
   FQN="clang::UncommonTemplateNameStorage::(anonymous)", NM="_ZN5clang27UncommonTemplateNameStorageE_Unnamed_union2",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang27UncommonTemplateNameStorageE_Unnamed_union2")
  //</editor-fold>
  protected static class/*union*/ Unnamed_union2 {
    public  BitsTag Bits = new BitsTag();
    public Object/*void P*/ PointerAlignment;
    
    @Override public String toString() {
      return "" + "Bits=" + Bits // NOI18N
                + ", PointerAlignment=" + PointerAlignment; // NOI18N
    }
  };
  protected Unnamed_union2 Unnamed_field = new Unnamed_union2();
  
  //<editor-fold defaultstate="collapsed" desc="clang::UncommonTemplateNameStorage::UncommonTemplateNameStorage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 64,
   FQN="clang::UncommonTemplateNameStorage::UncommonTemplateNameStorage", NM="_ZN5clang27UncommonTemplateNameStorageC1ENS0_4KindEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang27UncommonTemplateNameStorageC1ENS0_4KindEj")
  //</editor-fold>
  protected UncommonTemplateNameStorage(Kind kind, /*uint*/int size) {
    Unnamed_field.Bits.Kind = $uint2uint_2bits(kind.getValue());
    Unnamed_field.Bits.Size = size;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::UncommonTemplateNameStorage::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 70,
   FQN="clang::UncommonTemplateNameStorage::size", NM="_ZNK5clang27UncommonTemplateNameStorage4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZNK5clang27UncommonTemplateNameStorage4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return Unnamed_field.Bits.Size;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UncommonTemplateNameStorage::getAsOverloadedStorage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 72,
   FQN="clang::UncommonTemplateNameStorage::getAsOverloadedStorage", NM="_ZN5clang27UncommonTemplateNameStorage22getAsOverloadedStorageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang27UncommonTemplateNameStorage22getAsOverloadedStorageEv")
  //</editor-fold>
  public OverloadedTemplateStorage /*P*/ getAsOverloadedStorage() {
    return Unnamed_field.Bits.Kind == $int2uint_2bits(Kind.Overloaded.getValue()) ? reinterpret_cast(OverloadedTemplateStorage /*P*/ .class, this) : null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UncommonTemplateNameStorage::getAsSubstTemplateTemplateParm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 78,
   FQN="clang::UncommonTemplateNameStorage::getAsSubstTemplateTemplateParm", NM="_ZN5clang27UncommonTemplateNameStorage30getAsSubstTemplateTemplateParmEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang27UncommonTemplateNameStorage30getAsSubstTemplateTemplateParmEv")
  //</editor-fold>
  public SubstTemplateTemplateParmStorage /*P*/ getAsSubstTemplateTemplateParm() {
    return Unnamed_field.Bits.Kind == $int2uint_2bits(Kind.SubstTemplateTemplateParm.getValue()) ? reinterpret_cast(SubstTemplateTemplateParmStorage /*P*/ .class, this) : null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UncommonTemplateNameStorage::getAsSubstTemplateTemplateParmPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 84,
   FQN="clang::UncommonTemplateNameStorage::getAsSubstTemplateTemplateParmPack", NM="_ZN5clang27UncommonTemplateNameStorage34getAsSubstTemplateTemplateParmPackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang27UncommonTemplateNameStorage34getAsSubstTemplateTemplateParmPackEv")
  //</editor-fold>
  public SubstTemplateTemplateParmPackStorage /*P*/ getAsSubstTemplateTemplateParmPack() {
    return Unnamed_field.Bits.Kind == $int2uint_2bits(Kind.SubstTemplateTemplateParmPack.getValue()) ? reinterpret_cast(SubstTemplateTemplateParmPackStorage /*P*/ .class, this) : null;
  }

  
  @Override public String toString() {
    return "" + "Unnamed_field=" + Unnamed_field; // NOI18N
  }
}
