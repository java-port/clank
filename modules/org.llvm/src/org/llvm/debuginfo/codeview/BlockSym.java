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

package org.llvm.debuginfo.codeview;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;


// S_BLOCK32
//<editor-fold defaultstate="collapsed" desc="llvm::codeview::BlockSym">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/SymbolRecord.h", line = 866,
 FQN="llvm::codeview::BlockSym", NM="_ZN4llvm8codeview8BlockSymE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview8BlockSymE")
//</editor-fold>
public class BlockSym extends /*public*/ SymbolRecord {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::BlockSym::Hdr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/SymbolRecord.h", line = 868,
   FQN="llvm::codeview::BlockSym::Hdr", NM="_ZN4llvm8codeview8BlockSym3HdrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview8BlockSym3HdrE")
  //</editor-fold>
  public static class/*struct*/ Hdr {
    public llvm.support.ulittle32_t PtrParent;
    public llvm.support.ulittle32_t PtrEnd;
    public llvm.support.ulittle32_t CodeSize;
    public llvm.support.ulittle32_t CodeOffset;
    public llvm.support.ulittle16_t Segment;
    //<editor-fold defaultstate="collapsed" desc="llvm::codeview::BlockSym::Hdr::Hdr">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/SymbolRecord.h", line = 868,
     FQN="llvm::codeview::BlockSym::Hdr::Hdr", NM="_ZN4llvm8codeview8BlockSym3HdrC1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview8BlockSym3HdrC1ERKS2_")
    //</editor-fold>
    public /*inline*/ Hdr(final /*const*/ Hdr /*&*/ $Prm0) {
      // : PtrParent(.PtrParent), PtrEnd(.PtrEnd), CodeSize(.CodeSize), CodeOffset(.CodeOffset), Segment(.Segment) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::codeview::BlockSym::Hdr::Hdr">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/SymbolRecord.h", line = 868,
     FQN="llvm::codeview::BlockSym::Hdr::Hdr", NM="_ZN4llvm8codeview8BlockSym3HdrC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview8BlockSym3HdrC1EOS2_")
    //</editor-fold>
    public /*inline*/ Hdr(JD$Move _dparam, final Hdr /*&&*/$Prm0) {
      // : PtrParent(static_cast<Hdr &&>().PtrParent), PtrEnd(static_cast<Hdr &&>().PtrEnd), CodeSize(static_cast<Hdr &&>().CodeSize), CodeOffset(static_cast<Hdr &&>().CodeOffset), Segment(static_cast<Hdr &&>().Segment) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "PtrParent=" + PtrParent // NOI18N
                + ", PtrEnd=" + PtrEnd // NOI18N
                + ", CodeSize=" + CodeSize // NOI18N
                + ", CodeOffset=" + CodeOffset // NOI18N
                + ", Segment=" + Segment; // NOI18N
    }
  // Name: The null-terminated name follows.
    };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::BlockSym::BlockSym">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/SymbolRecord.h", line = 877,
   FQN="llvm::codeview::BlockSym::BlockSym", NM="_ZN4llvm8codeview8BlockSymC1EjPKNS1_3HdrENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview8BlockSymC1EjPKNS1_3HdrENS_9StringRefE")
  //</editor-fold>
  public BlockSym(/*uint32_t*/int RecordOffset, /*const*/ Hdr /*P*/ H, StringRef Name) {
    // : SymbolRecord(SymbolRecordKind::BlockSym), RecordOffset(RecordOffset), Header(*H), Name(Name) 
    super(SymbolRecordKind.BlockSym);
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::BlockSym::deserialize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/SymbolRecord.h", line = 881,
   FQN="llvm::codeview::BlockSym::deserialize", NM="_ZN4llvm8codeview8BlockSym11deserializeENS0_16SymbolRecordKindEjRNS_8ArrayRefIhEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview8BlockSym11deserializeENS0_16SymbolRecordKindEjRNS_8ArrayRefIhEE")
  //</editor-fold>
  public static ErrorOr<BlockSym> deserialize(/*SymbolRecordKind*//*uint16_t*/char Kind, 
             /*uint32_t*/int RecordOffset, 
             final ArrayRefUChar/*&*/ Data) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::BlockSym::getRelocationOffset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/SymbolRecord.h", line = 891,
   FQN="llvm::codeview::BlockSym::getRelocationOffset", NM="_ZNK4llvm8codeview8BlockSym19getRelocationOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview8BlockSym19getRelocationOffsetEv")
  //</editor-fold>
  public /*uint32_t*/int getRelocationOffset() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  public /*uint32_t*/int RecordOffset;
  public Hdr Header;
  public StringRef Name;
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::BlockSym::BlockSym">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/SymbolRecord.h", line = 866,
   FQN="llvm::codeview::BlockSym::BlockSym", NM="_ZN4llvm8codeview8BlockSymC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview8BlockSymC1EOS1_")
  //</editor-fold>
  public /*inline*/ BlockSym(JD$Move _dparam, final BlockSym /*&&*/$Prm0) {
    // : SymbolRecord(static_cast<BlockSym &&>()), RecordOffset(static_cast<BlockSym &&>().RecordOffset), Header(static_cast<BlockSym &&>().Header), Name(static_cast<BlockSym &&>().Name) 
    super(JD$Move.INSTANCE, $Prm0);
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "RecordOffset=" + RecordOffset // NOI18N
              + ", Header=" + Header // NOI18N
              + ", Name=" + Name // NOI18N
              + super.toString(); // NOI18N
  }
}
