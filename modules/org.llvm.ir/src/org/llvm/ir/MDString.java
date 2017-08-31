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

package org.llvm.ir;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.JD$Move;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.Metadata.MetadataKind;
import org.llvm.ir.Metadata.StorageType;

// end namespace mdconst

//===----------------------------------------------------------------------===//
/// \brief A single uniqued string.
///
/// These are used to efficiently contain a byte sequence for metadata.
/// MDString is always unnamed.
//<editor-fold defaultstate="collapsed" desc="llvm::MDString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 568,
 FQN="llvm::MDString", NM="_ZN4llvm8MDStringE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm8MDStringE")
//</editor-fold>
public class MDString extends /*public*/ Metadata implements NativeCloneable<MDString>, NativeMoveable<MDString> {
  /*friend  class StringMapEntry<MDString>*/
  
  //<editor-fold defaultstate="collapsed" desc="llvm::MDString::MDString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 571,
   FQN="llvm::MDString::MDString", NM="_ZN4llvm8MDStringC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm8MDStringC1ERKS0_")
  //</editor-fold>
  /*friend*/public/*private*/ MDString(final /*const*/ MDString /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::MDString::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 572,
   FQN="llvm::MDString::operator=", NM="_ZN4llvm8MDStringaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm8MDStringaSEOS0_")
  //</editor-fold>
  protected/*private*/ MDString /*&*/ $assignMove(final MDString /*&&*/$Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::MDString::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 573,
   FQN="llvm::MDString::operator=", NM="_ZN4llvm8MDStringaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm8MDStringaSERKS0_")
  //</editor-fold>
  protected/*private*/ MDString /*&*/ $assign(final /*const*/ MDString /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  private StringMapEntry<MDString> /*P*/ Entry;
  //<editor-fold defaultstate="collapsed" desc="llvm::MDString::MDString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 576,
   FQN="llvm::MDString::MDString", NM="_ZN4llvm8MDStringC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm8MDStringC1Ev")
  //</editor-fold>
  /*friend*/public/*private*/ MDString() {
    // : Metadata(MDStringKind, Uniqued), Entry(null) 
    //START JInit
    super(MetadataKind.MDStringKind.getValue(), StorageType.Uniqued);
    this.Entry = null;
    //END JInit
  }

/*public:*/
  
  //===----------------------------------------------------------------------===//
  // MDString implementation.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::MDString::get">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 417,
   FQN="llvm::MDString::get", NM="_ZN4llvm8MDString3getERNS_11LLVMContextENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm8MDString3getERNS_11LLVMContextENS_9StringRefE")
  //</editor-fold>
  public static MDString /*P*/ get(final LLVMContext /*&*/ Context, StringRef Str) {
    final StringMap<MDString/*,  BumpPtrAllocatorImpl<MallocAllocator, 4096, 4096>*/> /*&*/ Store = Context.pImpl.MDStringCache;
    std.pairTypeBool<StringMapIterator<MDString>> I = Store.emplace_second(new StringRef(Str), new MDString());
    final MDString /*&*/ MapEntry = I.first.$arrow().getValue();
    if (!I.second) {
      return /*AddrOf*/MapEntry;
    }
    MapEntry.Entry = /*AddrOf*/I.first.$star();
    return /*AddrOf*/MapEntry;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDString::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 580,
   FQN="llvm::MDString::get", NM="_ZN4llvm8MDString3getERNS_11LLVMContextEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm8MDString3getERNS_11LLVMContextEPKc")
  //</editor-fold>
  public static MDString /*P*/ get(final LLVMContext /*&*/ Context, /*const*/char$ptr/*char P*/ Str) {
    return MDString.get(Context, Native.$bool(Str) ? new StringRef(Str) : new StringRef());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MDString::getString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 427,
   FQN="llvm::MDString::getString", NM="_ZNK4llvm8MDString9getStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm8MDString9getStringEv")
  //</editor-fold>
  public StringRef getString() /*const*/ {
    assert ((Entry != null)) : "Expected to find string map entry";
    return Entry.first();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MDString::getLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 586,
   FQN="llvm::MDString::getLength", NM="_ZNK4llvm8MDString9getLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm8MDString9getLengthEv")
  //</editor-fold>
  public /*uint*/int getLength() /*const*/ {
    return (/*uint*/int)getString().size();
  }

  
  // JAVA: typedef StringRef::iterator iterator;
  
  /// \brief Pointer to the first byte of the string.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDString::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 591,
   FQN="llvm::MDString::begin", NM="_ZNK4llvm8MDString5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm8MDString5beginEv")
  //</editor-fold>
  public char$ptr begin() /*const*/ {
    return getString().begin();
  }

  
  /// \brief Pointer to one byte past the end of the string.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDString::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 594,
   FQN="llvm::MDString::end", NM="_ZNK4llvm8MDString3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm8MDString3endEv")
  //</editor-fold>
  public char$ptr end() /*const*/ {
    return getString().end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MDString::bytes_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 596,
   FQN="llvm::MDString::bytes_begin", NM="_ZNK4llvm8MDString11bytes_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm8MDString11bytes_beginEv")
  //</editor-fold>
  public /*const*/char$ptr/*uchar P*/ bytes_begin() /*const*/ {
    return getString()./*bytes_*/begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDString::bytes_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 597,
   FQN="llvm::MDString::bytes_end", NM="_ZNK4llvm8MDString9bytes_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm8MDString9bytes_endEv")
  //</editor-fold>
  public /*const*/char$ptr/*uchar P*/ bytes_end() /*const*/ {
    return getString()./*bytes_*/end();
  }

  
  /// \brief Methods for support type inquiry through isa, cast, and dyn_cast.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDString::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 600,
   FQN="llvm::MDString::classof", NM="_ZN4llvm8MDString7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm8MDString7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    return MD.getMetadataID() == MetadataKind.MDStringKind.getValue();
  }

  private static final MDString EMPTY = new MDString();
  public static MDString $Empty() { return EMPTY; }
  
  protected MDString(JD$Move _dparm, MDString $Prm0) {
    super($Prm0);
    this.Entry = $Prm0.Entry;
  }
  
  @Override public MDString clone() { 
    assert this == EMPTY || this.Entry == null: "only EMPTY const is expected to be cloned";
    assert this.getClass() == MDString.class : "Why not overridden in " + this.getClass();
    return new MDString();
  }
  
  @Override public MDString move() { 
    assert this.getClass() == MDString.class : "Why not overridden in " + this.getClass();
    return new MDString(JD$Move.INSTANCE, this);
  }
  
  @Override public String toString() {
    return "" + "Entry=" + (Entry == null ? "<null>" : Entry.first().toJavaString()) // NOI18N
              + super.toString(); // NOI18N
  }
}
