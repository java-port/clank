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

package org.llvm.mc;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;


/// SectionKind - This is a simple POD value that classifies the properties of
/// a section.  A section is classified into the deepest possible
/// classification, and then the target maps them onto their sections based on
/// what capabilities they have.
///
/// The comments below describe these as if they were an inheritance hierarchy
/// in order to explain the predicates below.
///
//<editor-fold defaultstate="collapsed" desc="llvm::SectionKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 23,
 FQN="llvm::SectionKind", NM="_ZN4llvm11SectionKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm11SectionKindE")
//</editor-fold>
public class SectionKind {
  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 24,
   FQN="llvm::SectionKind::Kind", NM="_ZN4llvm11SectionKind4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm11SectionKind4KindE")
  //</editor-fold>
  private enum Kind implements Native.NativeUIntEnum {
    /// Metadata - Debug info sections or other metadata.
    Metadata(0),
    
    /// Text - Text section, used for functions and other executable code.
    Text(Metadata.getValue() + 1),
    
    /// ReadOnly - Data that is never written to at program runtime by the
    /// program or the dynamic linker.  Things in the top-level readonly
    /// SectionKind are not mergeable.
    ReadOnly(Text.getValue() + 1),
    
    /// MergableCString - Any null-terminated string which allows merging.
    /// These values are known to end in a nul value of the specified size,
    /// not otherwise contain a nul value, and be mergable.  This allows the
    /// linker to unique the strings if it so desires.
    
    /// Mergeable1ByteCString - 1 byte mergable, null terminated, string.
    Mergeable1ByteCString(ReadOnly.getValue() + 1),
    
    /// Mergeable2ByteCString - 2 byte mergable, null terminated, string.
    Mergeable2ByteCString(Mergeable1ByteCString.getValue() + 1),
    
    /// Mergeable4ByteCString - 4 byte mergable, null terminated, string.
    Mergeable4ByteCString(Mergeable2ByteCString.getValue() + 1),
    
    /// MergeableConst - These are sections for merging fixed-length
    /// constants together.  For example, this can be used to unique
    /// constant pool entries etc.
    
    /// MergeableConst4 - This is a section used by 4-byte constants,
    /// for example, floats.
    MergeableConst4(Mergeable4ByteCString.getValue() + 1),
    
    /// MergeableConst8 - This is a section used by 8-byte constants,
    /// for example, doubles.
    MergeableConst8(MergeableConst4.getValue() + 1),
    
    /// MergeableConst16 - This is a section used by 16-byte constants,
    /// for example, vectors.
    MergeableConst16(MergeableConst8.getValue() + 1),
    
    /// MergeableConst32 - This is a section used by 32-byte constants,
    /// for example, vectors.
    MergeableConst32(MergeableConst16.getValue() + 1),
    
    /// Writeable - This is the base of all segments that need to be written
    /// to during program runtime.
    
    /// ThreadLocal - This is the base of all TLS segments.  All TLS
    /// objects must be writeable, otherwise there is no reason for them to
    /// be thread local!
    
    /// ThreadBSS - Zero-initialized TLS data objects.
    ThreadBSS(MergeableConst32.getValue() + 1),
    
    /// ThreadData - Initialized TLS data objects.
    ThreadData(ThreadBSS.getValue() + 1),
    
    /// GlobalWriteableData - Writeable data that is global (not thread
    /// local).
    
    /// BSS - Zero initialized writeable data.
    BSS(ThreadData.getValue() + 1),
    
    /// BSSLocal - This is BSS (zero initialized and writable) data
    /// which has local linkage.
    BSSLocal(BSS.getValue() + 1),
    
    /// BSSExtern - This is BSS data with normal external linkage.
    BSSExtern(BSSLocal.getValue() + 1),
    
    /// Common - Data with common linkage.  These represent tentative
    /// definitions, which always have a zero initializer and are never
    /// marked 'constant'.
    Common(BSSExtern.getValue() + 1),
    
    /// This is writeable data that has a non-zero initializer.
    Data(Common.getValue() + 1),
    
    /// ReadOnlyWithRel - These are global variables that are never
    /// written to by the program, but that have relocations, so they
    /// must be stuck in a writeable section so that the dynamic linker
    /// can write to them.  If it chooses to, the dynamic linker can
    /// mark the pages these globals end up on as read-only after it is
    /// done with its relocation phase.
    ReadOnlyWithRel(Data.getValue() + 1);

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
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  private  Kind K /*: 8*/;
/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::isMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 114,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 110,
   FQN="llvm::SectionKind::isMetadata", NM="_ZNK4llvm11SectionKind10isMetadataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm11SectionKind10isMetadataEv")
  //</editor-fold>
  public boolean isMetadata() /*const*/ {
    return K == Kind.Metadata;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::isText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 115,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 111,
   FQN="llvm::SectionKind::isText", NM="_ZNK4llvm11SectionKind6isTextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm11SectionKind6isTextEv")
  //</editor-fold>
  public boolean isText() /*const*/ {
    return K == Kind.Text;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::isReadOnly">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 117,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 113,
   FQN="llvm::SectionKind::isReadOnly", NM="_ZNK4llvm11SectionKind10isReadOnlyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm11SectionKind10isReadOnlyEv")
  //</editor-fold>
  public boolean isReadOnly() /*const*/ {
    return K == Kind.ReadOnly || isMergeableCString()
       || isMergeableConst();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::isMergeableCString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 122,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 118,
   FQN="llvm::SectionKind::isMergeableCString", NM="_ZNK4llvm11SectionKind18isMergeableCStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm11SectionKind18isMergeableCStringEv")
  //</editor-fold>
  public boolean isMergeableCString() /*const*/ {
    return K == Kind.Mergeable1ByteCString || K == Kind.Mergeable2ByteCString
       || K == Kind.Mergeable4ByteCString;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::isMergeable1ByteCString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 126,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 122,
   FQN="llvm::SectionKind::isMergeable1ByteCString", NM="_ZNK4llvm11SectionKind23isMergeable1ByteCStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm11SectionKind23isMergeable1ByteCStringEv")
  //</editor-fold>
  public boolean isMergeable1ByteCString() /*const*/ {
    return K == Kind.Mergeable1ByteCString;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::isMergeable2ByteCString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 127,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 123,
   FQN="llvm::SectionKind::isMergeable2ByteCString", NM="_ZNK4llvm11SectionKind23isMergeable2ByteCStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm11SectionKind23isMergeable2ByteCStringEv")
  //</editor-fold>
  public boolean isMergeable2ByteCString() /*const*/ {
    return K == Kind.Mergeable2ByteCString;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::isMergeable4ByteCString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 128,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 124,
   FQN="llvm::SectionKind::isMergeable4ByteCString", NM="_ZNK4llvm11SectionKind23isMergeable4ByteCStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm11SectionKind23isMergeable4ByteCStringEv")
  //</editor-fold>
  public boolean isMergeable4ByteCString() /*const*/ {
    return K == Kind.Mergeable4ByteCString;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::isMergeableConst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 130,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 126,
   FQN="llvm::SectionKind::isMergeableConst", NM="_ZNK4llvm11SectionKind16isMergeableConstEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm11SectionKind16isMergeableConstEv")
  //</editor-fold>
  public boolean isMergeableConst() /*const*/ {
    return K == Kind.MergeableConst4 || K == Kind.MergeableConst8
       || K == Kind.MergeableConst16 || K == Kind.MergeableConst32;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::isMergeableConst4">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 134,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 130,
   FQN="llvm::SectionKind::isMergeableConst4", NM="_ZNK4llvm11SectionKind17isMergeableConst4Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm11SectionKind17isMergeableConst4Ev")
  //</editor-fold>
  public boolean isMergeableConst4() /*const*/ {
    return K == Kind.MergeableConst4;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::isMergeableConst8">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 135,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 131,
   FQN="llvm::SectionKind::isMergeableConst8", NM="_ZNK4llvm11SectionKind17isMergeableConst8Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm11SectionKind17isMergeableConst8Ev")
  //</editor-fold>
  public boolean isMergeableConst8() /*const*/ {
    return K == Kind.MergeableConst8;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::isMergeableConst16">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 136,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 132,
   FQN="llvm::SectionKind::isMergeableConst16", NM="_ZNK4llvm11SectionKind18isMergeableConst16Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm11SectionKind18isMergeableConst16Ev")
  //</editor-fold>
  public boolean isMergeableConst16() /*const*/ {
    return K == Kind.MergeableConst16;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::isMergeableConst32">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 137,
   FQN="llvm::SectionKind::isMergeableConst32", NM="_ZNK4llvm11SectionKind18isMergeableConst32Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm11SectionKind18isMergeableConst32Ev")
  //</editor-fold>
  public boolean isMergeableConst32() /*const*/ {
    return K == Kind.MergeableConst32;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::isWriteable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 139,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 134,
   FQN="llvm::SectionKind::isWriteable", NM="_ZNK4llvm11SectionKind11isWriteableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm11SectionKind11isWriteableEv")
  //</editor-fold>
  public boolean isWriteable() /*const*/ {
    return isThreadLocal() || isGlobalWriteableData();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::isThreadLocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 143,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 138,
   FQN="llvm::SectionKind::isThreadLocal", NM="_ZNK4llvm11SectionKind13isThreadLocalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm11SectionKind13isThreadLocalEv")
  //</editor-fold>
  public boolean isThreadLocal() /*const*/ {
    return K == Kind.ThreadData || K == Kind.ThreadBSS;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::isThreadBSS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 147,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 142,
   FQN="llvm::SectionKind::isThreadBSS", NM="_ZNK4llvm11SectionKind11isThreadBSSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm11SectionKind11isThreadBSSEv")
  //</editor-fold>
  public boolean isThreadBSS() /*const*/ {
    return K == Kind.ThreadBSS;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::isThreadData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 148,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 143,
   FQN="llvm::SectionKind::isThreadData", NM="_ZNK4llvm11SectionKind12isThreadDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm11SectionKind12isThreadDataEv")
  //</editor-fold>
  public boolean isThreadData() /*const*/ {
    return K == Kind.ThreadData;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::isGlobalWriteableData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 150,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 145,
   FQN="llvm::SectionKind::isGlobalWriteableData", NM="_ZNK4llvm11SectionKind21isGlobalWriteableDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm11SectionKind21isGlobalWriteableDataEv")
  //</editor-fold>
  public boolean isGlobalWriteableData() /*const*/ {
    return isBSS() || isCommon() || isData() || isReadOnlyWithRel();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::isBSS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 154,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 149,
   FQN="llvm::SectionKind::isBSS", NM="_ZNK4llvm11SectionKind5isBSSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm11SectionKind5isBSSEv")
  //</editor-fold>
  public boolean isBSS() /*const*/ {
    return K == Kind.BSS || K == Kind.BSSLocal || K == Kind.BSSExtern;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::isBSSLocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 155,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 150,
   FQN="llvm::SectionKind::isBSSLocal", NM="_ZNK4llvm11SectionKind10isBSSLocalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm11SectionKind10isBSSLocalEv")
  //</editor-fold>
  public boolean isBSSLocal() /*const*/ {
    return K == Kind.BSSLocal;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::isBSSExtern">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 156,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 151,
   FQN="llvm::SectionKind::isBSSExtern", NM="_ZNK4llvm11SectionKind11isBSSExternEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm11SectionKind11isBSSExternEv")
  //</editor-fold>
  public boolean isBSSExtern() /*const*/ {
    return K == Kind.BSSExtern;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::isCommon">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 158,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 153,
   FQN="llvm::SectionKind::isCommon", NM="_ZNK4llvm11SectionKind8isCommonEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm11SectionKind8isCommonEv")
  //</editor-fold>
  public boolean isCommon() /*const*/ {
    return K == Kind.Common;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::isData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 160,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 155,
   FQN="llvm::SectionKind::isData", NM="_ZNK4llvm11SectionKind6isDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm11SectionKind6isDataEv")
  //</editor-fold>
  public boolean isData() /*const*/ {
    return K == Kind.Data;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::isReadOnlyWithRel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 162,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 157,
   FQN="llvm::SectionKind::isReadOnlyWithRel", NM="_ZNK4llvm11SectionKind17isReadOnlyWithRelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm11SectionKind17isReadOnlyWithRelEv")
  //</editor-fold>
  public boolean isReadOnlyWithRel() /*const*/ {
    return K == Kind.ReadOnlyWithRel;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 166,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 161,
   FQN="llvm::SectionKind::get", NM="_ZN4llvm11SectionKind3getENS0_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm11SectionKind3getENS0_4KindE")
  //</editor-fold>
  private static SectionKind get(Kind K) {
    SectionKind Res/*J*/= new SectionKind();
    Res.K = K;
    return Res;
  }

/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::getMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 173,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 168,
   FQN="llvm::SectionKind::getMetadata", NM="_ZN4llvm11SectionKind11getMetadataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm11SectionKind11getMetadataEv")
  //</editor-fold>
  public static SectionKind getMetadata() {
    return SectionKind.get(Kind.Metadata);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::getText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 174,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 169,
   FQN="llvm::SectionKind::getText", NM="_ZN4llvm11SectionKind7getTextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm11SectionKind7getTextEv")
  //</editor-fold>
  public static SectionKind getText() {
    return SectionKind.get(Kind.Text);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::getReadOnly">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 175,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 170,
   FQN="llvm::SectionKind::getReadOnly", NM="_ZN4llvm11SectionKind11getReadOnlyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm11SectionKind11getReadOnlyEv")
  //</editor-fold>
  public static SectionKind getReadOnly() {
    return SectionKind.get(Kind.ReadOnly);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::getMergeable1ByteCString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 176,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 171,
   FQN="llvm::SectionKind::getMergeable1ByteCString", NM="_ZN4llvm11SectionKind24getMergeable1ByteCStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm11SectionKind24getMergeable1ByteCStringEv")
  //</editor-fold>
  public static SectionKind getMergeable1ByteCString() {
    return SectionKind.get(Kind.Mergeable1ByteCString);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::getMergeable2ByteCString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 179,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 174,
   FQN="llvm::SectionKind::getMergeable2ByteCString", NM="_ZN4llvm11SectionKind24getMergeable2ByteCStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm11SectionKind24getMergeable2ByteCStringEv")
  //</editor-fold>
  public static SectionKind getMergeable2ByteCString() {
    return SectionKind.get(Kind.Mergeable2ByteCString);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::getMergeable4ByteCString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 182,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 177,
   FQN="llvm::SectionKind::getMergeable4ByteCString", NM="_ZN4llvm11SectionKind24getMergeable4ByteCStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm11SectionKind24getMergeable4ByteCStringEv")
  //</editor-fold>
  public static SectionKind getMergeable4ByteCString() {
    return SectionKind.get(Kind.Mergeable4ByteCString);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::getMergeableConst4">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 185,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 180,
   FQN="llvm::SectionKind::getMergeableConst4", NM="_ZN4llvm11SectionKind18getMergeableConst4Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm11SectionKind18getMergeableConst4Ev")
  //</editor-fold>
  public static SectionKind getMergeableConst4() {
    return SectionKind.get(Kind.MergeableConst4);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::getMergeableConst8">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 186,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 181,
   FQN="llvm::SectionKind::getMergeableConst8", NM="_ZN4llvm11SectionKind18getMergeableConst8Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm11SectionKind18getMergeableConst8Ev")
  //</editor-fold>
  public static SectionKind getMergeableConst8() {
    return SectionKind.get(Kind.MergeableConst8);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::getMergeableConst16">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 187,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 182,
   FQN="llvm::SectionKind::getMergeableConst16", NM="_ZN4llvm11SectionKind19getMergeableConst16Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm11SectionKind19getMergeableConst16Ev")
  //</editor-fold>
  public static SectionKind getMergeableConst16() {
    return SectionKind.get(Kind.MergeableConst16);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::getMergeableConst32">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 188,
   FQN="llvm::SectionKind::getMergeableConst32", NM="_ZN4llvm11SectionKind19getMergeableConst32Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm11SectionKind19getMergeableConst32Ev")
  //</editor-fold>
  public static SectionKind getMergeableConst32() {
    return SectionKind.get(Kind.MergeableConst32);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::getThreadBSS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 189,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 183,
   FQN="llvm::SectionKind::getThreadBSS", NM="_ZN4llvm11SectionKind12getThreadBSSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm11SectionKind12getThreadBSSEv")
  //</editor-fold>
  public static SectionKind getThreadBSS() {
    return SectionKind.get(Kind.ThreadBSS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::getThreadData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 190,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 184,
   FQN="llvm::SectionKind::getThreadData", NM="_ZN4llvm11SectionKind13getThreadDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm11SectionKind13getThreadDataEv")
  //</editor-fold>
  public static SectionKind getThreadData() {
    return SectionKind.get(Kind.ThreadData);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::getBSS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 191,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 185,
   FQN="llvm::SectionKind::getBSS", NM="_ZN4llvm11SectionKind6getBSSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm11SectionKind6getBSSEv")
  //</editor-fold>
  public static SectionKind getBSS() {
    return SectionKind.get(Kind.BSS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::getBSSLocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 192,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 186,
   FQN="llvm::SectionKind::getBSSLocal", NM="_ZN4llvm11SectionKind11getBSSLocalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm11SectionKind11getBSSLocalEv")
  //</editor-fold>
  public static SectionKind getBSSLocal() {
    return SectionKind.get(Kind.BSSLocal);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::getBSSExtern">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 193,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 187,
   FQN="llvm::SectionKind::getBSSExtern", NM="_ZN4llvm11SectionKind12getBSSExternEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm11SectionKind12getBSSExternEv")
  //</editor-fold>
  public static SectionKind getBSSExtern() {
    return SectionKind.get(Kind.BSSExtern);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::getCommon">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 194,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 188,
   FQN="llvm::SectionKind::getCommon", NM="_ZN4llvm11SectionKind9getCommonEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm11SectionKind9getCommonEv")
  //</editor-fold>
  public static SectionKind getCommon() {
    return SectionKind.get(Kind.Common);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::getData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 195,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 189,
   FQN="llvm::SectionKind::getData", NM="_ZN4llvm11SectionKind7getDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm11SectionKind7getDataEv")
  //</editor-fold>
  public static SectionKind getData() {
    return SectionKind.get(Kind.Data);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::getReadOnlyWithRel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 196,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", old_line = 190,
   FQN="llvm::SectionKind::getReadOnlyWithRel", NM="_ZN4llvm11SectionKind18getReadOnlyWithRelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm11SectionKind18getReadOnlyWithRelEv")
  //</editor-fold>
  public static SectionKind getReadOnlyWithRel() {
    return SectionKind.get(Kind.ReadOnlyWithRel);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::SectionKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 23,
   FQN="llvm::SectionKind::SectionKind", NM="_ZN4llvm11SectionKindC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm11SectionKindC1Ev")
  //</editor-fold>
  public /*inline*/ SectionKind() {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::SectionKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 23,
   FQN="llvm::SectionKind::SectionKind", NM="_ZN4llvm11SectionKindC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm11SectionKindC1ERKS0_")
  //</editor-fold>
  public /*inline*/ SectionKind(final /*const*/ SectionKind /*&*/ $Prm0) {
    // : K(.K) 
    //START JInit
    this.K = $Prm0.K;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::SectionKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 23,
   FQN="llvm::SectionKind::SectionKind", NM="_ZN4llvm11SectionKindC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm11SectionKindC1EOS0_")
  //</editor-fold>
  public /*inline*/ SectionKind(JD$Move _dparam, final SectionKind /*&&*/$Prm0) {
    // : K(static_cast<SectionKind &&>().K) 
    //START JInit
    this.K = $Prm0.K;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SectionKind::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/SectionKind.h", line = 23,
   FQN="llvm::SectionKind::operator=", NM="_ZN4llvm11SectionKindaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm11SectionKindaSEOS0_")
  //</editor-fold>
  public /*inline*/ SectionKind /*&*/ $assignMove(final SectionKind /*&&*/$Prm0) {
    this.K = $Prm0.K;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "K=" + K; // NOI18N
  }
}
