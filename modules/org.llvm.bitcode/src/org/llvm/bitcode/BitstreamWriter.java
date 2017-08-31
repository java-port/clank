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

package org.llvm.bitcode;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Casts.reinterpret_cast;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.bitcode.bitc.*;
import org.llvm.support.endian.EndianGlobals;
import org.llvm.support.llvm.support.endian;
import org.llvm.support.llvm.support.endianness;
import static org.llvm.support.llvm.support.unaligned;

//<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 28,
 FQN="llvm::BitstreamWriter", NM="_ZN4llvm15BitstreamWriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriterE")
//</editor-fold>
public class BitstreamWriter implements Destructors.ClassWithDestructor {
  private final SmallString/*&*/ Out;
  
  /// CurBit - Always between 0 and 31 inclusive, specifies the next bit to use.
  private /*uint*/int CurBit;
  
  /// CurValue - The current value.  Only bits < CurBit are valid.
  private /*uint32_t*/int CurValue;
  
  /// CurCodeSize - This is the declared size of code values used for the
  /// current block, in bits.
  private /*uint*/int CurCodeSize;
  
  /// BlockInfoCurBID - When emitting a BLOCKINFO_BLOCK, this is the currently
  /// selected BLOCK ID.
  private /*uint*/int BlockInfoCurBID;
  
  /// CurAbbrevs - Abbrevs installed at in this block.
  private std.vector<IntrusiveRefCntPtr<BitCodeAbbrev>> CurAbbrevs;

  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::Block">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 48,
   FQN="llvm::BitstreamWriter::Block", NM="_ZN4llvm15BitstreamWriter5BlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter5BlockE")
  //</editor-fold>
  private static class/*struct*/ Block implements Destructors.ClassWithDestructor, NativePOD<Block>, NativeMoveable<Block> {
    public /*uint*/int PrevCodeSize;
    public /*size_t*/int StartSizeWord;
    public std.vector<IntrusiveRefCntPtr<BitCodeAbbrev>> PrevAbbrevs;
    //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::Block::Block">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 52,
     FQN="llvm::BitstreamWriter::Block::Block", NM="_ZN4llvm15BitstreamWriter5BlockC1Ejj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter5BlockC1Ejj")
    //</editor-fold>
    public Block(/*uint*/int PCS, /*size_t*/int SSW) {
      // : PrevCodeSize(PCS), StartSizeWord(SSW), PrevAbbrevs() 
      //START JInit
      this.PrevCodeSize = PCS;
      this.StartSizeWord = SSW;
      this.PrevAbbrevs = new std.vector<IntrusiveRefCntPtr<BitCodeAbbrev>>(new IntrusiveRefCntPtr<BitCodeAbbrev>());
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::Block::Block">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 48,
     FQN="llvm::BitstreamWriter::Block::Block", NM="_ZN4llvm15BitstreamWriter5BlockC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter5BlockC1EOS1_")
    //</editor-fold>
    public /*inline*/ Block(JD$Move _dparam, final Block /*&&*/$Prm0) {
      // : PrevCodeSize(static_cast<Block &&>().PrevCodeSize), StartSizeWord(static_cast<Block &&>().StartSizeWord), PrevAbbrevs(static_cast<Block &&>().PrevAbbrevs) 
      //START JInit
      this.PrevCodeSize = $Prm0.PrevCodeSize;
      this.StartSizeWord = $Prm0.StartSizeWord;
      this.PrevAbbrevs = new std.vector<IntrusiveRefCntPtr<BitCodeAbbrev>>(JD$Move.INSTANCE, $Prm0.PrevAbbrevs);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::Block::~Block">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 48,
     FQN="llvm::BitstreamWriter::Block::~Block", NM="_ZN4llvm15BitstreamWriter5BlockD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter5BlockD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      PrevAbbrevs.$destroy();
      //END JDestroy
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    Block() {
      this.PrevAbbrevs = new std.vector<IntrusiveRefCntPtr<BitCodeAbbrev>>(new IntrusiveRefCntPtr<BitCodeAbbrev>());
      this.PrevCodeSize = 0;
    }
    
    public Block(Block other) {
      this.PrevCodeSize = other.PrevCodeSize;
      this.StartSizeWord = other.StartSizeWord;
      this.PrevAbbrevs = new std.vector<IntrusiveRefCntPtr<BitCodeAbbrev>>(other.PrevAbbrevs);
    }
    
    @Override public Block clone() {
      return new Block(this);
    }

    @Override
    public Block $assign(Block $Prm0) {
      this.PrevCodeSize = $Prm0.PrevCodeSize;
      this.StartSizeWord = $Prm0.StartSizeWord;
      this.PrevAbbrevs.$assign($Prm0.PrevAbbrevs);
      return this;
    }

    @Override
    public Block $assignMove(Block $Prm0) {
      this.PrevCodeSize = $Prm0.PrevCodeSize;
      this.StartSizeWord = $Prm0.StartSizeWord;
      this.PrevAbbrevs.$assignMove($Prm0.PrevAbbrevs);
      return this;
    }

    @Override
    public Block move() {
      return new Block(JD$Move.INSTANCE, this);
    }


    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "PrevCodeSize=" + PrevCodeSize // NOI18N
                + ", StartSizeWord=" + StartSizeWord // NOI18N
                + ", PrevAbbrevs=" + PrevAbbrevs; // NOI18N
    }
  };
  
  /// BlockScope - This tracks the current blocks that we have entered.
  private std.vector<Block> BlockScope;
  
  /// BlockInfo - This contains information emitted to BLOCKINFO_BLOCK blocks.
  /// These describe abbreviations that all blocks of the specified ID inherit.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::BlockInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 60,
   FQN="llvm::BitstreamWriter::BlockInfo", NM="_ZN4llvm15BitstreamWriter9BlockInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter9BlockInfoE")
  //</editor-fold>
  private static class/*struct*/ BlockInfo implements Destructors.ClassWithDestructor, NativeCloneable {
    public /*uint*/int BlockID;
    public std.vector<IntrusiveRefCntPtr<BitCodeAbbrev>> Abbrevs;
    //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::BlockInfo::BlockInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 60,
     FQN="llvm::BitstreamWriter::BlockInfo::BlockInfo", NM="_ZN4llvm15BitstreamWriter9BlockInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter9BlockInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ BlockInfo(JD$Move _dparam, final BlockInfo /*&&*/$Prm0) {
      // : BlockID(static_cast<BlockInfo &&>().BlockID), Abbrevs(static_cast<BlockInfo &&>().Abbrevs) 
      //START JInit
      this.BlockID = $Prm0.BlockID;
      this.Abbrevs = new std.vector<IntrusiveRefCntPtr<BitCodeAbbrev>>(JD$Move.INSTANCE, $Prm0.Abbrevs);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::BlockInfo::~BlockInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 60,
     FQN="llvm::BitstreamWriter::BlockInfo::~BlockInfo", NM="_ZN4llvm15BitstreamWriter9BlockInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter9BlockInfoD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Abbrevs.$destroy();
      //END JDestroy
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::BlockInfo::BlockInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 60,
     FQN="llvm::BitstreamWriter::BlockInfo::BlockInfo", NM="_ZN4llvm15BitstreamWriter9BlockInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter9BlockInfoC1Ev")
    //</editor-fold>
    public /*inline*/ BlockInfo() {
      // : Abbrevs() 
      //START JInit
      this.Abbrevs = new std.vector<IntrusiveRefCntPtr<BitCodeAbbrev>>(new IntrusiveRefCntPtr<BitCodeAbbrev>());
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public /*inline*/ BlockInfo(final BlockInfo /*&&*/$Prm0) {
      // : BlockID(static_cast<BlockInfo &&>().BlockID), Abbrevs(static_cast<BlockInfo &&>().Abbrevs) 
      //START JInit
      this.BlockID = $Prm0.BlockID;
      this.Abbrevs = new std.vector<IntrusiveRefCntPtr<BitCodeAbbrev>>($Prm0.Abbrevs);
      //END JInit
    }

    @Override public BlockInfo clone() {
      return new BlockInfo(this);
    }


    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "BlockID=" + BlockID // NOI18N
                + ", Abbrevs=" + Abbrevs; // NOI18N
    }
  };
  private std.vector<BlockInfo> BlockInfoRecords;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::WriteByte">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 66,
   FQN="llvm::BitstreamWriter::WriteByte", NM="_ZN4llvm15BitstreamWriter9WriteByteEh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter9WriteByteEh")
  //</editor-fold>
  private void WriteByte(/*uchar*/byte Value) {
    Out.push_back(Value);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::WriteWord">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 70,
   FQN="llvm::BitstreamWriter::WriteWord", NM="_ZN4llvm15BitstreamWriter9WriteWordEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter9WriteWordEj")
  //</editor-fold>
  private void WriteWord(/*uint*/int Value) {
    Value = EndianGlobals.byte_swap(Value, endianness.little);
    //Value.$set(endian.</*uint32_t*/int, support.endianness.little>byte_swap(Value.$star()));
//    Out.append(toOut);//reinterpret_cast(/*const*/char$ptr/*char P*/ .class, $AddrOf(Value)), 
//        reinterpret_cast(/*const*/char$ptr/*char P*/ .class, $AddrOf(Value).$add(1)));
    Out.append(1, NativeType.ToByteArray.get0(Value));
    Out.append(1, NativeType.ToByteArray.get1(Value));
    Out.append(1, NativeType.ToByteArray.get2(Value));
    Out.append(1, NativeType.ToByteArray.get3(Value));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::GetBufferOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 76,
   FQN="llvm::BitstreamWriter::GetBufferOffset", NM="_ZNK4llvm15BitstreamWriter15GetBufferOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm15BitstreamWriter15GetBufferOffsetEv")
  //</editor-fold>
  private /*size_t*/int GetBufferOffset() /*const*/ {
    return Out.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::GetWordIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 78,
   FQN="llvm::BitstreamWriter::GetWordIndex", NM="_ZNK4llvm15BitstreamWriter12GetWordIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm15BitstreamWriter12GetWordIndexEv")
  //</editor-fold>
  private /*size_t*/int GetWordIndex() /*const*/ {
    /*size_t*/int Offset = GetBufferOffset();
    assert ((Offset & 3) == 0) : "Not 32-bit aligned";
    return $div_uint(Offset, 4);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::BitstreamWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 85,
   FQN="llvm::BitstreamWriter::BitstreamWriter", NM="_ZN4llvm15BitstreamWriterC1ERNS_15SmallVectorImplIcEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriterC1ERNS_15SmallVectorImplIcEE")
  //</editor-fold>
  public /*explicit*/ BitstreamWriter(final SmallString/*&*/ O) {
    // : Out(O), CurBit(0), CurValue(0), CurCodeSize(2), CurAbbrevs(), BlockScope(), BlockInfoRecords() 
    //START JInit
    this./*&*/Out=/*&*/O;
    this.CurBit = 0;
    this.CurValue = 0;
    this.CurCodeSize = 2;
    this.CurAbbrevs = new std.vector<IntrusiveRefCntPtr<BitCodeAbbrev>>(new IntrusiveRefCntPtr<BitCodeAbbrev>());
    this.BlockScope = new std.vector<Block>(new Block());
    this.BlockInfoRecords = new std.vector<BlockInfo>(new BlockInfo());
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::~BitstreamWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 88,
   FQN="llvm::BitstreamWriter::~BitstreamWriter", NM="_ZN4llvm15BitstreamWriterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriterD0Ev")
  //</editor-fold>
  public void $destroy() {
    assert (CurBit == 0) : "Unflushed data remaining";
    assert (BlockScope.empty() && CurAbbrevs.empty()) : "Block imbalance";
    //START JDestroy
    BlockInfoRecords.$destroy();
    BlockScope.$destroy();
    CurAbbrevs.$destroy();
    //END JDestroy
  }

  
  /// \brief Retrieve the current position in the stream, in bits.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::GetCurrentBitNo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 94,
   FQN="llvm::BitstreamWriter::GetCurrentBitNo", NM="_ZNK4llvm15BitstreamWriter15GetCurrentBitNoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm15BitstreamWriter15GetCurrentBitNoEv")
  //</editor-fold>
  public long/*uint64_t*/ GetCurrentBitNo() /*const*/ {
    return $uint2ulong(GetBufferOffset() * 8 + CurBit);
  }

  
  /// \brief Retrieve the number of bits currently used to encode an abbrev ID.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::GetAbbrevIDWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 97,
   FQN="llvm::BitstreamWriter::GetAbbrevIDWidth", NM="_ZNK4llvm15BitstreamWriter16GetAbbrevIDWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm15BitstreamWriter16GetAbbrevIDWidthEv")
  //</editor-fold>
  public /*uint*/int GetAbbrevIDWidth() /*const*/ {
    return CurCodeSize;
  }

  
  //===--------------------------------------------------------------------===//
  // Basic Primitives for emitting bits to the stream.
  //===--------------------------------------------------------------------===//

  /// Backpatch a 32-bit word in the output at the given bit offset
  /// with the specified value.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::BackpatchWord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 105,
   FQN="llvm::BitstreamWriter::BackpatchWord", NM="_ZN4llvm15BitstreamWriter13BackpatchWordEyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter13BackpatchWordEyj")
  //</editor-fold>
  public void BackpatchWord(long/*uint64_t*/ BitNo, /*uint*/int NewWord) {
    //JAVA: using namespace llvm::support;
    /*uint*/int ByteNo = $ullong2uint($div_ulong_ullong(BitNo, $int2ullong(8)));
    assert ((!(endian./*<endianness.little, unaligned>*/readAtBitAlignment$UInt(endianness.little, unaligned, $AddrOf(Out.ptr$at(ByteNo)), BitNo & $int2ullong(7)) != 0))) : "Expected to be patching over 0-value placeholders";
    endian./*<endianness.little, unaligned>*/writeAtBitAlignment$UInt(endianness.little, unaligned, $AddrOf(Out.ptr$at(ByteNo)), NewWord, BitNo & $int2ullong(7));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::Emit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 115,
   FQN="llvm::BitstreamWriter::Emit", NM="_ZN4llvm15BitstreamWriter4EmitEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter4EmitEjj")
  //</editor-fold>
  public void Emit(/*uint32_t*/int Val, /*uint*/int NumBits) {
    assert ((NumBits != 0) && $lesseq_uint(NumBits, 32)) : "Invalid value size!";
    assert ((Val & ~(~0/*U*/ >>> (32 - NumBits))) == 0) : "High bits set!";
    CurValue |= Val << CurBit;
    if ($less_uint(CurBit + NumBits, 32)) {
      CurBit += NumBits;
      return;
    }
    
    // Add the current word.
    WriteWord(CurValue);
    if ((CurBit != 0)) {
      CurValue = Val >>> (32 - CurBit);
    } else {
      CurValue = 0;
    }
    CurBit = (CurBit + NumBits) & 31;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::Emit64">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 134,
   FQN="llvm::BitstreamWriter::Emit64", NM="_ZN4llvm15BitstreamWriter6Emit64Eyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter6Emit64Eyj")
  //</editor-fold>
  public void Emit64(long/*uint64_t*/ Val, /*uint*/int NumBits) {
    if ($lesseq_uint(NumBits, 32)) {
      Emit((/*uint32_t*/int)$ulong2uint(Val), NumBits);
    } else {
      Emit((/*uint32_t*/int)/*JAVA: $ulong2uint*/(Val), 32);
      Emit((/*uint32_t*/int)$ulong2uint((Val >>> 32)), NumBits - 32);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::FlushToWord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 143,
   FQN="llvm::BitstreamWriter::FlushToWord", NM="_ZN4llvm15BitstreamWriter11FlushToWordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter11FlushToWordEv")
  //</editor-fold>
  public void FlushToWord() {
    if ((CurBit != 0)) {
      WriteWord(CurValue);
      CurBit = 0;
      CurValue = 0;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::EmitVBR">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 151,
   FQN="llvm::BitstreamWriter::EmitVBR", NM="_ZN4llvm15BitstreamWriter7EmitVBREjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter7EmitVBREjj")
  //</editor-fold>
  public void EmitVBR(/*uint32_t*/int Val, /*uint*/int NumBits) {
    assert ($lesseq_uint(NumBits, 32)) : "Too many bits to emit!";
    /*uint32_t*/int Threshold = 1/*U*/ << (NumBits - 1);
    
    // Emit the bits with VBR encoding, NumBits-1 bits at a time.
    while ($greatereq_uint(Val, Threshold)) {
      Emit((Val & ((1 << (NumBits - 1)) - 1)) | (1 << (NumBits - 1)), NumBits);
      Val >>>= NumBits - 1;
    }
    
    Emit(Val, NumBits);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::EmitVBR64">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 164,
   FQN="llvm::BitstreamWriter::EmitVBR64", NM="_ZN4llvm15BitstreamWriter9EmitVBR64Eyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter9EmitVBR64Eyj")
  //</editor-fold>
  public void EmitVBR64(long/*uint64_t*/ Val, /*uint*/int NumBits) {
    assert ($lesseq_uint(NumBits, 32)) : "Too many bits to emit!";
    if ($uint2ulong((/*uint32_t*/int)Val) == Val) {
      EmitVBR((/*uint32_t*/int)$ulong2uint(Val), NumBits);
      /*JAVA:return*/return;
    }
    
    /*uint32_t*/int Threshold = 1/*U*/ << (NumBits - 1);
    
    // Emit the bits with VBR encoding, NumBits-1 bits at a time.
    while ($greatereq_ulong_uint(Val, Threshold)) {
      Emit(((/*uint32_t*/int)/*JAVA $ulong2uint*/(Val) & ((1 << (NumBits - 1)) - 1))
             | (1 << (NumBits - 1)), NumBits);
      Val >>>= NumBits - 1;
    }
    
    Emit((/*uint32_t*/int)$ulong2uint(Val), NumBits);
  }

  
  /// EmitCode - Emit the specified code.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::EmitCode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 182,
   FQN="llvm::BitstreamWriter::EmitCode", NM="_ZN4llvm15BitstreamWriter8EmitCodeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter8EmitCodeEj")
  //</editor-fold>
  public void EmitCode(/*uint*/int Val) {
    Emit(Val, CurCodeSize);
  }

  
  //===--------------------------------------------------------------------===//
  // Block Manipulation
  //===--------------------------------------------------------------------===//
  
  /// getBlockInfo - If there is block info for the specified ID, return it,
  /// otherwise return null.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::getBlockInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 192,
   FQN="llvm::BitstreamWriter::getBlockInfo", NM="_ZN4llvm15BitstreamWriter12getBlockInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter12getBlockInfoEj")
  //</editor-fold>
  public BlockInfo /*P*/ getBlockInfo(/*uint*/int BlockID) {
    // Common case, the most recent entry matches BlockID.
    if (!BlockInfoRecords.empty() && BlockInfoRecords.back().BlockID == BlockID) {
      return $AddrOf(BlockInfoRecords.back());
    }
    
    for (/*uint*/int i = 0, e = ((/*static_cast*//*uint*/int)(BlockInfoRecords.size()));
         i != e; ++i)  {
      if (BlockInfoRecords.$at(i).BlockID == BlockID) {
        return $AddrOf(BlockInfoRecords.$at(i));
      }
    }
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::EnterSubblock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 204,
   FQN="llvm::BitstreamWriter::EnterSubblock", NM="_ZN4llvm15BitstreamWriter13EnterSubblockEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter13EnterSubblockEjj")
  //</editor-fold>
  public void EnterSubblock(/*uint*/int BlockID, /*uint*/int CodeLen) {
    // Block header:
    //    [ENTER_SUBBLOCK, blockid, newcodelen, <align4bytes>, blocklen]
    EmitCode(FixedAbbrevIDs.ENTER_SUBBLOCK);
    EmitVBR(BlockID, StandardWidths.BlockIDWidth);
    EmitVBR(CodeLen, StandardWidths.CodeLenWidth);
    FlushToWord();
    
    /*size_t*/int BlockSizeWordIndex = GetWordIndex();
    /*uint*/int OldCodeSize = CurCodeSize;
    
    // Emit a placeholder, which will be replaced when the block is popped.
    Emit(0, StandardWidths.BlockSizeWidth);
    
    CurCodeSize = CodeLen;
    
    // Push the outer block's abbrev set onto the stack, start out with an
    // empty abbrev set.
    BlockScope.emplace_back(new Block(OldCodeSize, BlockSizeWordIndex));
    BlockScope.back().PrevAbbrevs.swap(CurAbbrevs);
    {
      
      // If there is a blockinfo for this BlockID, add all the predefined abbrevs
      // to the abbrev list.
      BlockInfo /*P*/ Info = getBlockInfo(BlockID);
      if ((Info != null)) {
        CurAbbrevs.insert$T(new std.vector.iterator</*const*/ IntrusiveRefCntPtr<BitCodeAbbrev> /*P*/ >(CurAbbrevs.end()), Info.Abbrevs.begin(), 
            Info.Abbrevs.end());
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::ExitBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 233,
   FQN="llvm::BitstreamWriter::ExitBlock", NM="_ZN4llvm15BitstreamWriter9ExitBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter9ExitBlockEv")
  //</editor-fold>
  public void ExitBlock() {
    assert (!BlockScope.empty()) : "Block scope imbalance!";
    final /*const*/ Block /*&*/ B = BlockScope.back();
    
    // Block tail:
    //    [END_BLOCK, <align4bytes>]
    EmitCode(FixedAbbrevIDs.END_BLOCK);
    FlushToWord();
    
    // Compute the size of the block, in words, not counting the size field.
    /*size_t*/int SizeInWords = GetWordIndex() - B.StartSizeWord - 1;
    long/*uint64_t*/ BitNo = ((long/*uint64_t*/)($uint2ulong(B.StartSizeWord))) * $int2ullong(32);
    
    // Update the block size field in the header of this sub-block.
    BackpatchWord(BitNo, SizeInWords);
    
    // Restore the inner block's code size and abbrev table.
    CurCodeSize = B.PrevCodeSize;
    CurAbbrevs.$assign(std.move(B.PrevAbbrevs));
    BlockScope.pop_back();
  }


  //===--------------------------------------------------------------------===//
  // Record Emission
  //===--------------------------------------------------------------------===//
  /*private:*/
  /// EmitAbbreviatedLiteral - Emit a literal value according to its abbrev
  /// record.  This is a no-op, since the abbrev specifies the literal to use.
  /*template <typename uintty> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::EmitAbbreviatedLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 263,
   FQN="llvm::BitstreamWriter::EmitAbbreviatedLiteral", NM="Tpl__ZN4llvm15BitstreamWriter22EmitAbbreviatedLiteralERKNS_15BitCodeAbbrevOpET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=Tpl__ZN4llvm15BitstreamWriter22EmitAbbreviatedLiteralERKNS_15BitCodeAbbrevOpET_")
  //</editor-fold>
  private </*typename*/ uintty> void EmitAbbreviatedLiteral(final /*const*/ BitCodeAbbrevOp /*&*/ Op, uintty V) {
    throw new UnsupportedOperationException("Use one of specialized EmitAbbreviatedLiteral$... for " + NativeTrace.getIdentityStr(V));
  }
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::EmitAbbreviatedLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 263,
   FQN="llvm::BitstreamWriter::EmitAbbreviatedLiteral", NM="_ZN4llvm15BitstreamWriter22EmitAbbreviatedLiteralIjEEvRKNS_15BitCodeAbbrevOpET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter22EmitAbbreviatedLiteralIjEEvRKNS_15BitCodeAbbrevOpET_")
  //</editor-fold>
  private void EmitAbbreviatedLiteral$UInt(final /*const*/ BitCodeAbbrevOp /*&*/ Op, /*uint*/int V) {
    assert (Op.isLiteral()) : "Not a literal";
    // If the abbrev specifies the literal value to use, don't emit
    // anything.
    assert ($uint2ullong(V) == Op.getLiteralValue()) : "Invalid abbrev for record!";
  }
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::EmitAbbreviatedLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 263,
   FQN="llvm::BitstreamWriter::EmitAbbreviatedLiteral", NM="_ZN4llvm15BitstreamWriter22EmitAbbreviatedLiteralIyEEvRKNS_15BitCodeAbbrevOpET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter22EmitAbbreviatedLiteralIyEEvRKNS_15BitCodeAbbrevOpET_")
  //</editor-fold>
  private void EmitAbbreviatedLiteral$ULLong(final /*const*/ BitCodeAbbrevOp /*&*/ Op, /*ullong*/long V) {
    assert (Op.isLiteral()) : "Not a literal";
    // If the abbrev specifies the literal value to use, don't emit
    // anything.
    assert (V == Op.getLiteralValue()) : "Invalid abbrev for record!";
  }
  
  /*template <typename uintty> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::EmitAbbreviatedField">
  @Converted(kind = Converted.Kind.DELETED,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 274,
   FQN="llvm::BitstreamWriter::EmitAbbreviatedField", NM="Tpl__ZN4llvm15BitstreamWriter20EmitAbbreviatedFieldERKNS_15BitCodeAbbrevOpET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=Tpl__ZN4llvm15BitstreamWriter20EmitAbbreviatedFieldERKNS_15BitCodeAbbrevOpET_")
  //</editor-fold>
  private </*typename*/ uintty> void EmitAbbreviatedField(final /*const*/ BitCodeAbbrevOp /*&*/ Op, uintty V) {
    throw new UnsupportedOperationException("Use one of specialized methods EmitAbbreviatedField$... for " + NativeTrace.getIdentityStr(V));
  }  
  /// EmitAbbreviatedField - Emit a single scalar field value with the specified
  /// encoding.
  //template <typename uintty = unsigned int> 
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::EmitAbbreviatedField">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 274,
   FQN="llvm::BitstreamWriter::EmitAbbreviatedField", NM="_ZN4llvm15BitstreamWriter20EmitAbbreviatedFieldIjEEvRKNS_15BitCodeAbbrevOpET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter20EmitAbbreviatedFieldIjEEvRKNS_15BitCodeAbbrevOpET_")
  //</editor-fold>
  private void EmitAbbreviatedField$UInt(final /*const*/ BitCodeAbbrevOp /*&*/ Op, /*uint*/int V) {
    assert (!Op.isLiteral()) : "Literals should use EmitAbbreviatedLiteral!";

    // Encode the value as we are commanded.
    switch (Op.getEncoding()) {
     default:
      throw new llvm_unreachable("Unknown encoding!");
     case Fixed:
      if ((Op.getEncodingData() != 0)) {
        Emit((/*uint*/int)V, (/*uint*/int)$ulong2uint(Op.getEncodingData()));
      }
      break;
     case VBR:
      if ((Op.getEncodingData() != 0)) {
        EmitVBR64($uint2ulong(V), (/*uint*/int)$ulong2uint(Op.getEncodingData()));
      }
      break;
     case Char6:
      Emit(BitCodeAbbrevOp.EncodeChar6((/*char*/byte)$uint2char(V)), 6);
      break;
    }
  }
  //template <typename uintty = unsigned char> 
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::EmitAbbreviatedField">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 274,
   FQN="llvm::BitstreamWriter::EmitAbbreviatedField", NM="_ZN4llvm15BitstreamWriter20EmitAbbreviatedFieldIhEEvRKNS_15BitCodeAbbrevOpET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter20EmitAbbreviatedFieldIhEEvRKNS_15BitCodeAbbrevOpET_")
  //</editor-fold>
  private void EmitAbbreviatedField$UChar(final /*const*/ BitCodeAbbrevOp /*&*/ Op, /*uchar*/byte V) {
    assert (!Op.isLiteral()) : "Literals should use EmitAbbreviatedLiteral!";
    
    // Encode the value as we are commanded.    
    switch (Op.getEncoding()) {
     default:
      throw new llvm_unreachable("Unknown encoding!");
     case Fixed:
      if ((Op.getEncodingData() != 0)) {
        Emit((/*uint*/int)$uchar2uint(V), (/*uint*/int)$ulong2uint(Op.getEncodingData()));
      }
      break;
     case VBR:
      if ((Op.getEncodingData() != 0)) {
        EmitVBR64($uchar2ulong(V), (/*uint*/int)$ulong2uint(Op.getEncodingData()));
      }
      break;
     case Char6:
      Emit(BitCodeAbbrevOp.EncodeChar6((/*char*/byte)V), 6);
      break;
    }
  }
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::EmitAbbreviatedField">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 274,
   FQN="llvm::BitstreamWriter::EmitAbbreviatedField", NM="_ZN4llvm15BitstreamWriter20EmitAbbreviatedFieldIyEEvRKNS_15BitCodeAbbrevOpET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter20EmitAbbreviatedFieldIyEEvRKNS_15BitCodeAbbrevOpET_")
  //</editor-fold>
  private void EmitAbbreviatedField$ULLong(final /*const*/ BitCodeAbbrevOp /*&*/ Op, /*ullong*/long V) {
    assert (!Op.isLiteral()) : "Literals should use EmitAbbreviatedLiteral!";
    
    // Encode the value as we are commanded.
    switch (Op.getEncoding()) {
     default:
      throw new llvm_unreachable("Unknown encoding!");
     case Fixed:
      if ((Op.getEncodingData() != 0)) {
        Emit((/*uint*/int)$ullong2uint(V), (/*uint*/int)$ulong2uint(Op.getEncodingData()));
      }
      break;
     case VBR:
      if ((Op.getEncodingData() != 0)) {
        EmitVBR64(V, (/*uint*/int)$ulong2uint(Op.getEncodingData()));
      }
      break;
     case Char6:
      Emit(BitCodeAbbrevOp.EncodeChar6((/*char*/byte)$ullong2char(V)), 6);
      break;
    }
  }

  
  /// EmitRecordWithAbbrevImpl - This is the core implementation of the record
  /// emission code.  If BlobData is non-null, then it specifies an array of
  /// data that should be emitted as part of the Blob or Array operand that is
  /// known to exist at the end of the record. If Code is specified, then
  /// it is the record code to emit before the Vals, which must not contain
  /// the code.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::EmitRecordWithAbbrevImpl">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 301,
   FQN="llvm::BitstreamWriter::EmitRecordWithAbbrevImpl", NM="_ZN4llvm15BitstreamWriter24EmitRecordWithAbbrevImplIjEEvjNS_8ArrayRefIT_EENS_9StringRefENS_8OptionalIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter24EmitRecordWithAbbrevImplIjEEvjNS_8ArrayRefIT_EENS_9StringRefENS_8OptionalIjEE")
  //</editor-fold>
  private void EmitRecordWithAbbrevImpl$UInt(/*uint*/int Abbrev, ArrayRefUInt Vals, 
                               StringRef Blob, OptionalUInt Code) {
    // JAVA: clone only when non-empty Blob
    /*const*/char$ptr/*char P*/ BlobData = Blob.data();
    /*uint*/int BlobLen = (/*uint*/int)Blob.size();
    BlobData = (BlobLen == 0 ? BlobData : $Clone(BlobData));
    /*uint*/int AbbrevNo = Abbrev - FixedAbbrevIDs.FIRST_APPLICATION_ABBREV;
    assert ($less_uint(AbbrevNo, CurAbbrevs.size())) : "Invalid abbrev #!";
    /*const*/ BitCodeAbbrev /*P*/ Abbv = CurAbbrevs.$at(AbbrevNo).get();
    
    EmitCode(Abbrev);
    
    /*uint*/int i = 0;
    /*uint*/int e = ((/*static_cast*//*uint*/int)(Abbv.getNumOperandInfos()));
    if (Code.$bool()) {
      assert ((e != 0)) : "Expected non-empty abbreviation";
      final /*const*/ BitCodeAbbrevOp /*&*/ Op = Abbv.getOperandInfo(i++);
      if (Op.isLiteral()) {
        EmitAbbreviatedLiteral$UInt(Op, Code.getValue());
      } else {
        assert (Op.getEncoding() != BitCodeAbbrevOp.Encoding.Array && Op.getEncoding() != BitCodeAbbrevOp.Encoding.Blob) : "Expected literal or scalar";
        EmitAbbreviatedField$UInt(Op, Code.getValue());
      }
    }
    
    /*uint*/int RecordIdx = 0;
    for (; i != e; ++i) {
      final /*const*/ BitCodeAbbrevOp /*&*/ Op = Abbv.getOperandInfo(i);
      if (Op.isLiteral()) {
        assert ($less_uint(RecordIdx, Vals.size())) : "Invalid abbrev/record";
        EmitAbbreviatedLiteral$UInt(Op, Vals.$at(RecordIdx));
        ++RecordIdx;
      } else if (Op.getEncoding() == BitCodeAbbrevOp.Encoding.Array) {
        // Array case.
        assert (i + 2 == e) : "array op not second to last?";
        final /*const*/ BitCodeAbbrevOp /*&*/ EltEnc = Abbv.getOperandInfo(++i);
        
        // If this record has blob data, emit it, otherwise we must have record
        // entries to encode this way.
        if (Native.$bool(BlobData)) {
          assert (RecordIdx == Vals.size()) : "Blob data and record entries specified for array!";
          // Emit a vbr6 to indicate the number of elements present.
          EmitVBR(((/*static_cast*//*uint32_t*/int)(BlobLen)), 6);
          
          // Emit each field.
          for (/*uint*/int i$1 = 0; i$1 != BlobLen; ++i$1)  {
            EmitAbbreviatedField$UChar(EltEnc, (/*uchar*/byte)BlobData.$at(i$1));
          }
          
          // Know that blob data is consumed for assertion below.
          BlobData = null;
        } else {
          // Emit a vbr6 to indicate the number of elements present.
          EmitVBR(((/*static_cast*//*uint32_t*/int)(Vals.size() - RecordIdx)), 6);
          
          // Emit each field.
          for (/*uint*/int e$1 = Vals.size(); RecordIdx != e$1; ++RecordIdx)  {
            EmitAbbreviatedField$UInt(EltEnc, Vals.$at(RecordIdx));
          }
        }
      } else if (Op.getEncoding() == BitCodeAbbrevOp.Encoding.Blob) {
        // If this record has blob data, emit it, otherwise we must have record
        // entries to encode this way.
        if (Native.$bool(BlobData)) {
          assert (RecordIdx == Vals.size()) : "Blob data and record entries specified for blob operand!";
          assert ($eq_ptr(Blob.data(), BlobData)) : "BlobData got moved";
          assert (Blob.size() == BlobLen) : "BlobLen got changed";
          emitBlob(new StringRef(Blob));
          BlobData = null;
        } else {
          emitBlob$UInt(Vals.slice(RecordIdx));
        }
      } else { // Single scalar field.
        assert ($less_uint(RecordIdx, Vals.size())) : "Invalid abbrev/record";
        EmitAbbreviatedField$UInt(Op, Vals.$at(RecordIdx));
        ++RecordIdx;
      }
    }
    assert (RecordIdx == Vals.size()) : "Not all record operands emitted!";
    assert ($eq_ptr(BlobData, null)) : "Blob data specified for record that doesn't use it!";
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::EmitRecordWithAbbrevImpl">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 301,
   FQN="llvm::BitstreamWriter::EmitRecordWithAbbrevImpl", NM="_ZN4llvm15BitstreamWriter24EmitRecordWithAbbrevImplIyEEvjNS_8ArrayRefIT_EENS_9StringRefENS_8OptionalIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter24EmitRecordWithAbbrevImplIyEEvjNS_8ArrayRefIT_EENS_9StringRefENS_8OptionalIjEE")
  //</editor-fold>
  private void EmitRecordWithAbbrevImpl$ULLong(/*uint*/int Abbrev, ArrayRefULong Vals, 
                                 StringRef Blob, OptionalUInt Code) {
    // JAVA: clone only when non-empty Blob
    /*const*/char$ptr/*char P*/ BlobData = Blob.data();
    /*uint*/int BlobLen = (/*uint*/int)Blob.size();
    BlobData = (BlobLen == 0 ? BlobData : $Clone(BlobData));
    /*uint*/int AbbrevNo = Abbrev - FixedAbbrevIDs.FIRST_APPLICATION_ABBREV;
    assert ($less_uint(AbbrevNo, CurAbbrevs.size())) : "Invalid abbrev #!";
    /*const*/ BitCodeAbbrev /*P*/ Abbv = CurAbbrevs.$at(AbbrevNo).get();
    
    EmitCode(Abbrev);
    
    /*uint*/int i = 0;
    /*uint*/int e = ((/*static_cast*//*uint*/int)(Abbv.getNumOperandInfos()));
    if (Code.$bool()) {
      assert ((e != 0)) : "Expected non-empty abbreviation";
      final /*const*/ BitCodeAbbrevOp /*&*/ Op = Abbv.getOperandInfo(i++);
      if (Op.isLiteral()) {
        EmitAbbreviatedLiteral$UInt(Op, Code.getValue());
      } else {
        assert (Op.getEncoding() != BitCodeAbbrevOp.Encoding.Array && Op.getEncoding() != BitCodeAbbrevOp.Encoding.Blob) : "Expected literal or scalar";
        EmitAbbreviatedField$UInt(Op, Code.getValue());
      }
    }
    
    /*uint*/int RecordIdx = 0;
    for (; i != e; ++i) {
      final /*const*/ BitCodeAbbrevOp /*&*/ Op = Abbv.getOperandInfo(i);
      if (Op.isLiteral()) {
        assert ($less_uint(RecordIdx, Vals.size())) : "Invalid abbrev/record";
        EmitAbbreviatedLiteral$ULLong(Op, Vals.$at(RecordIdx));
        ++RecordIdx;
      } else if (Op.getEncoding() == BitCodeAbbrevOp.Encoding.Array) {
        // Array case.
        assert (i + 2 == e) : "array op not second to last?";
        final /*const*/ BitCodeAbbrevOp /*&*/ EltEnc = Abbv.getOperandInfo(++i);
        
        // If this record has blob data, emit it, otherwise we must have record
        // entries to encode this way.
        if (Native.$bool(BlobData)) {
          assert (RecordIdx == Vals.size()) : "Blob data and record entries specified for array!";
          // Emit a vbr6 to indicate the number of elements present.
          EmitVBR(((/*static_cast*//*uint32_t*/int)(BlobLen)), 6);
          
          // Emit each field.
          for (/*uint*/int i$1 = 0; i$1 != BlobLen; ++i$1)  {
            EmitAbbreviatedField$UChar(EltEnc, (/*uchar*/byte)BlobData.$at(i$1));
          }
          
          // Know that blob data is consumed for assertion below.
          BlobData = null;
        } else {
          // Emit a vbr6 to indicate the number of elements present.
          EmitVBR(((/*static_cast*//*uint32_t*/int)(Vals.size() - RecordIdx)), 6);
          
          // Emit each field.
          for (/*uint*/int e$1 = Vals.size(); RecordIdx != e$1; ++RecordIdx)  {
            EmitAbbreviatedField$ULLong(EltEnc, Vals.$at(RecordIdx));
          }
        }
      } else if (Op.getEncoding() == BitCodeAbbrevOp.Encoding.Blob) {
        // If this record has blob data, emit it, otherwise we must have record
        // entries to encode this way.
        if (Native.$bool(BlobData)) {
          assert (RecordIdx == Vals.size()) : "Blob data and record entries specified for blob operand!";
          assert ($eq_ptr(Blob.data(), BlobData)) : "BlobData got moved";
          assert (Blob.size() == BlobLen) : "BlobLen got changed";
          emitBlob(new StringRef(Blob));
          BlobData = null;
        } else {
          emitBlob$ULLong(Vals.slice(RecordIdx));
        }
      } else { // Single scalar field.
        assert ($less_uint(RecordIdx, Vals.size())) : "Invalid abbrev/record";
        EmitAbbreviatedField$ULLong(Op, Vals.$at(RecordIdx));
        ++RecordIdx;
      }
    }
    assert (RecordIdx == Vals.size()) : "Not all record operands emitted!";
    assert ($eq_ptr(BlobData, null)) : "Blob data specified for record that doesn't use it!";
  }
  
  private <Container> void EmitRecordWithAbbrevImpl(int Abbrev, ArrayRef<Container> makeArrayRef, StringRef stringRef, OptionalUInt optionalUInt) {
    throw new UnsupportedOperationException("Use specialization EmitRecordWithAbbrevImpl for " + NativeTrace.getIdentityStr(makeArrayRef)); //To change body of generated methods, choose Tools | Templates.
  }
  
//  /*template <typename uintty> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::EmitRecordWithAbbrevImpl">
//  @Converted(kind = Converted.Kind.DELETED,
//   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 301,
//   FQN="llvm::BitstreamWriter::EmitRecordWithAbbrevImpl", NM="Tpl__ZN4llvm15BitstreamWriter24EmitRecordWithAbbrevImplEjNS_8ArrayRefIT_EENS_9StringRefENS_8OptionalIjEE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=Tpl__ZN4llvm15BitstreamWriter24EmitRecordWithAbbrevImplEjNS_8ArrayRefIT_EENS_9StringRefENS_8OptionalIjEE")
//  //</editor-fold>
//  private </*typename*/ uintty> void EmitRecordWithAbbrevImpl(/*uint*/int Abbrev, ArrayRef<uintty> Vals, 
//                          StringRef Blob, OptionalUInt Code) {
//    /*const*/char$ptr/*char P*/ BlobData = $tryClone(Blob.data());
//    /*uint*/int BlobLen = (/*uint*/int)Blob.size();
//    /*uint*/int AbbrevNo = Abbrev - bitc.FixedAbbrevIDs.FIRST_APPLICATION_ABBREV.getValue();
//    assert ($less_uint(AbbrevNo, CurAbbrevs.size())) : "Invalid abbrev #!";
//    /*const*/ BitCodeAbbrev /*P*/ Abbv = CurAbbrevs.$at(AbbrevNo).get();
//
//    EmitCode(Abbrev);
//
//    /*uint*/int i = 0;
//    /*uint*/int e = ((/*static_cast*//*uint*/int)(Abbv.getNumOperandInfos()));
//    if (Code.$bool()) {
//      assert ((e != 0)) : "Expected non-empty abbreviation";
//      final /*const*/ BitCodeAbbrevOp /*&*/ Op = Abbv.getOperandInfo(i++);
//      if (Op.isLiteral()) {
//        EmitAbbreviatedLiteral(Op, Code.getValue());
//      } else {
//        assert (Op.getEncoding() != BitCodeAbbrevOp.Encoding.Array && Op.getEncoding() != BitCodeAbbrevOp.Encoding.Blob) : "Expected literal or scalar";
//        EmitAbbreviatedField(Op, Code.getValue());
//      }
//    }
//
//    /*uint*/int RecordIdx = 0;
//    for (; i != e; ++i) {
//      final /*const*/ BitCodeAbbrevOp /*&*/ Op = Abbv.getOperandInfo(i);
//      if (Op.isLiteral()) {
//        assert Native.$bool(Native.$less(RecordIdx, Vals.size())) : "Invalid abbrev/record";
//        EmitAbbreviatedLiteral(Op, Vals[RecordIdx]);
//        ++RecordIdx;
//      } else if (Op.getEncoding() == BitCodeAbbrevOp.Encoding.Array) {
//        assert (i + 2 == e) : "array op not second to last?";
//        final /*const*/ BitCodeAbbrevOp /*&*/ EltEnc = Abbv.getOperandInfo(++i);
//        if (Native.$bool(BlobData)) {
//          assert Native.$bool(Native.$eq(RecordIdx, Vals.size())) : "Blob data and record entries specified for array!";
//          EmitVBR(((/*static_cast*//*uint32_t*/int)(BlobLen)), 6);
//          for (/*uint*/int i$1 = 0; i$1 != BlobLen; ++i$1)  {
//            EmitAbbreviatedField(EltEnc, (/*uchar*/byte)BlobData.$at(i$1));
//          }
//          BlobData = null;
//        } else {
//          EmitVBR(((/*static_cast*//*uint32_t*/int)(Vals.size() - RecordIdx)), 6);
//          for (/*uint*/int e$1 = Vals.size(); RecordIdx != e$1; ++RecordIdx)  {
//            EmitAbbreviatedField(EltEnc, Vals[RecordIdx]);
//          }
//        }
//      } else if (Op.getEncoding() == BitCodeAbbrevOp.Encoding.Blob) {
//        if (Native.$bool(BlobData)) {
//          assert Native.$bool(Native.$eq(RecordIdx, Vals.size())) : "Blob data and record entries specified for blob operand!";
//          assert ($eq_ptr(Blob.data(), BlobData)) : "BlobData got moved";
//          assert (Blob.size() == BlobLen) : "BlobLen got changed";
//          emitBlob(new StringRef(Blob));
//          BlobData = null;
//        } else {
//          emitBlob(Vals.slice(RecordIdx));
//        }
//      } else {
//        assert Native.$bool(Native.$less(RecordIdx, Vals.size())) : "Invalid abbrev/record";
//        EmitAbbreviatedField(Op, Vals[RecordIdx]);
//        ++RecordIdx;
//      }
//    }
//    assert Native.$bool(Native.$eq(RecordIdx, Vals.size())) : "Not all record operands emitted!";
//    assert ($eq_ptr(BlobData, null)) : "Blob data specified for record that doesn't use it!";
//  }

/*public:*/
  /// Emit a blob, including flushing before and tail-padding.
  //template <class UIntTy = unsigned char> 
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::emitBlob">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 389,
   FQN="llvm::BitstreamWriter::emitBlob", NM="_ZN4llvm15BitstreamWriter8emitBlobIhEEvNS_8ArrayRefIT_EEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter8emitBlobIhEEvNS_8ArrayRefIT_EEb")
  //</editor-fold>
  public void emitBlob$UChar(ArrayRefUChar Bytes, boolean ShouldEmitSize) {
    // Emit a vbr6 to indicate the number of elements present.
    if (ShouldEmitSize) {
      EmitVBR(((/*static_cast*//*uint32_t*/int)(Bytes.size())), 6);
    }

    // Flush to a 32-bit alignment boundary.
    FlushToWord();

    // Emit literal bytes.
    for (final /*const*/Byte/*uchar &*/ B : Bytes) {
      assert (/*<8>*/isUInt8($uchar2ulong(B))) : "Value too large to emit as byte";
      WriteByte((/*uchar*/byte)B);
    }

    // Align end to 32-bits.
    while (((GetBufferOffset() & 3) != 0)) {
      WriteByte($int2uchar(0));
    }
  }
  /// Emit a blob, including flushing before and tail-padding.
  //template <class UIntTy = unsigned char> 
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::emitBlob">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 389,
   FQN="llvm::BitstreamWriter::emitBlob", NM="_ZN4llvm15BitstreamWriter8emitBlobIhEEvNS_8ArrayRefIT_EEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter8emitBlobIhEEvNS_8ArrayRefIT_EEb")
  //</editor-fold>
  public void emitBlob$UChar(ArrayRefChar Bytes, boolean ShouldEmitSize) {
    // Emit a vbr6 to indicate the number of elements present.
    if (ShouldEmitSize) {
      EmitVBR(((/*static_cast*//*uint32_t*/int)(Bytes.size())), 6);
    }

    // Flush to a 32-bit alignment boundary.
    FlushToWord();

    // Emit literal bytes.
    for (final /*const*/Byte/*uchar &*/ B : Bytes) {
      assert (/*<8>*/isUInt8($uchar2ulong(B))) : "Value too large to emit as byte";
      WriteByte((/*uchar*/byte)B);
    }

    // Align end to 32-bits.
    while (((GetBufferOffset() & 3) != 0)) {
      WriteByte($int2uchar(0));
    }
  }
  //template <class UIntTy = unsigned int> 
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::emitBlob">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 389,
   FQN="llvm::BitstreamWriter::emitBlob", NM="_ZN4llvm15BitstreamWriter8emitBlobIjEEvNS_8ArrayRefIT_EEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter8emitBlobIjEEvNS_8ArrayRefIT_EEb")
  //</editor-fold>
  public void emitBlob$UInt(ArrayRefUInt Bytes) {
    emitBlob$UInt(Bytes, true);
  }
  public void emitBlob$UInt(ArrayRefUInt Bytes, boolean ShouldEmitSize/*= true*/) {
    if (ShouldEmitSize) {
      EmitVBR(((/*static_cast*//*uint32_t*/int)(Bytes.size())), 6);
    }
    FlushToWord();
    for (final /*const*/Integer/*uint &*/ B : Bytes) {
      assert (/*<8>*/isUInt8($uint2ulong(B))) : "Value too large to emit as byte";
      WriteByte((/*uchar*/byte)$uint2uchar(B));
    }
    while (((GetBufferOffset() & 3) != 0)) {
      WriteByte($int2uchar(0));
    }
  }
  //template <class UIntTy = unsigned long long> 
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::emitBlob">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 389,
   FQN="llvm::BitstreamWriter::emitBlob", NM="_ZN4llvm15BitstreamWriter8emitBlobIyEEvNS_8ArrayRefIT_EEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter8emitBlobIyEEvNS_8ArrayRefIT_EEb")
  //</editor-fold>
  public void emitBlob$ULLong(ArrayRefULong Bytes) {
    emitBlob$ULLong(Bytes, true);
  }
  public void emitBlob$ULLong(ArrayRefULong Bytes, boolean ShouldEmitSize/*= true*/) {
    if (ShouldEmitSize) {
      EmitVBR(((/*static_cast*//*uint32_t*/int)(Bytes.size())), 6);
    }
    FlushToWord();
    for (final /*const*/Long/*ullong &*/ B : Bytes) {
      assert (/*<8>*/isUInt8(B)) : "Value too large to emit as byte";
      WriteByte((/*uchar*/byte)$ullong2uchar(B));
    }
    while (((GetBufferOffset() & 3) != 0)) {
      WriteByte($int2uchar(0));
    }
  }
//  /*template <class UIntTy> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::emitBlob">
//  @Converted(kind = Converted.Kind.DELETED,
//   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 389,
//   FQN="llvm::BitstreamWriter::emitBlob", NM="Tpl__ZN4llvm15BitstreamWriter8emitBlobENS_8ArrayRefIT_EEb",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=Tpl__ZN4llvm15BitstreamWriter8emitBlobENS_8ArrayRefIT_EEb")
//  //</editor-fold>
//  public </*class*/ UIntTy> void emitBlob$T(ArrayRef<UIntTy> Bytes) {
//    emitBlob$T(Bytes, true);
//  }
//  public </*class*/ UIntTy> void emitBlob$T(ArrayRef<UIntTy> Bytes, boolean ShouldEmitSize/*= true*/) {
//    if (ShouldEmitSize) {
//      EmitVBR(((/*static_cast*//*uint32_t*/int)(Bytes.size())), 6);
//    }
//    FlushToWord();
//    for (final auto /*const*/ /*&*/ B : Bytes) {
//      assert Native.$bool(isUInt<8>(B)) : "Value too large to emit as byte";
//      WriteByte((/*uchar*/byte)B);
//    }
//    while (((GetBufferOffset() & 3) != 0)) {
//      WriteByte($int2uchar(0));
//    }
//  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::emitBlob">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 407,
   FQN="llvm::BitstreamWriter::emitBlob", NM="_ZN4llvm15BitstreamWriter8emitBlobENS_9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter8emitBlobENS_9StringRefEb")
  //</editor-fold>
  public void emitBlob(StringRef Bytes) {
    emitBlob(Bytes, true);
  }
  public void emitBlob(StringRef Bytes, boolean ShouldEmitSize/*= true*/) {
    emitBlob$UChar(makeArrayRef$Char(reinterpret_cast(/*const*/char$ptr/*uint8_t*//*P*/ .class, Bytes.data()), Bytes.size()), 
        ShouldEmitSize);
  }

  
  /// EmitRecord - Emit the specified record to the stream, using an abbrev if
  /// we have one to compress the output.
  //template <typename Container = SmallVector<unsigned int, 2>> 
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::EmitRecord">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 415,
   FQN="llvm::BitstreamWriter::EmitRecord", NM="_ZN4llvm15BitstreamWriter10EmitRecordINS_11SmallVectorIjLj2EEEEEvjRKT_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter10EmitRecordINS_11SmallVectorIjLj2EEEEEvjRKT_j")
  //</editor-fold>
  public void EmitRecord(/*uint*/int Code, final /*const*/SmallVectorImplUInt /*&*/ Vals) {
    EmitRecord(Code, Vals, 0);
  }
  public void EmitRecord(/*uint*/int Code, final /*const*/SmallVectorImplUInt /*&*/ Vals, /*uint*/int Abbrev/*= 0*/) {
    if (!(Abbrev != 0)) {
      // If we don't have an abbrev to use, emit this in its fully unabbreviated
      // form.
      /*uint32_t*/int Count = ((/*static_cast*//*uint32_t*/int)(/*makeArrayRef$UInt*/(Vals).size()));
      EmitCode(FixedAbbrevIDs.UNABBREV_RECORD);
      EmitVBR(Code, 6);
      EmitVBR(Count, 6);
      for (/*uint*/int i = 0, e = Count; i != e; ++i)  {
        EmitVBR64($uint2ulong(Vals.$at$Const(i)), 6);
      }
      return;
    }

    EmitRecordWithAbbrevImpl$UInt(Abbrev, makeArrayRef$UInt(Vals), new StringRef(), new OptionalUInt(JD$T$C$R.INSTANCE, Code));
  }
 
  //template <typename Container = SmallVectorImpl<unsigned long long>> 
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::EmitRecord">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 415,
   FQN="llvm::BitstreamWriter::EmitRecord", NM="_ZN4llvm15BitstreamWriter10EmitRecordINS_15SmallVectorImplIyEEEEvjRKT_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter10EmitRecordINS_15SmallVectorImplIyEEEEvjRKT_j")
  //</editor-fold>
  public void EmitRecord(/*uint*/int Code, final /*const*/SmallVectorImplULong /*&*/ Vals) {
    EmitRecord(Code, Vals, 0);
  }
  public void EmitRecord(/*uint*/int Code, final /*const*/SmallVectorImplULong /*&*/ Vals, /*uint*/int Abbrev) {
    if (!(Abbrev != 0)) {
      /*uint32_t*/int Count = ((/*static_cast*//*uint32_t*/int)(/*makeArrayRef*/(Vals).size()));
      EmitCode(FixedAbbrevIDs.UNABBREV_RECORD);
      EmitVBR(Code, 6);
      EmitVBR(Count, 6);
      for (/*uint*/int i = 0, e = Count; i != e; ++i)  {
        EmitVBR64(Vals.$at$Const(i), 6);
      }
      return;
    }

    EmitRecordWithAbbrevImpl$ULLong(Abbrev, makeArrayRef$ULLong(Vals), new StringRef(), new OptionalUInt(JD$T$C$R.INSTANCE, Code));
  }
  
  //template <typename Container = ArrayRef<unsigned long long>> 
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::EmitRecord">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 415,
   FQN="llvm::BitstreamWriter::EmitRecord", NM="_ZN4llvm15BitstreamWriter10EmitRecordINS_8ArrayRefIyEEEEvjRKT_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter10EmitRecordINS_8ArrayRefIyEEEEvjRKT_j")
  //</editor-fold>
  public void EmitRecord(/*uint*/int Code, final /*const*/ArrayRefULong /*&*/ Vals) {
    EmitRecord(Code, Vals, 0);
  }
  public void EmitRecord(/*uint*/int Code, final /*const*/ArrayRefULong /*&*/ Vals, /*uint*/int Abbrev/*= 0*/) {
    if (!(Abbrev != 0)) {
      /*uint32_t*/int Count = Vals.size();//(/*static_cast*//*uint32_t*/int)(makeArrayRef_ArrayRef$T$C(Vals).size()));
      EmitCode(FixedAbbrevIDs.UNABBREV_RECORD);
      EmitVBR(Code, 6);
      EmitVBR(Count, 6);
      for (/*uint*/int i = 0, e = Count; i != e; ++i)  {
        EmitVBR64(Vals.$at(i), 6);
      }
      return;
    }

    EmitRecordWithAbbrevImpl$ULLong(Abbrev, Vals/*makeArrayRef_ArrayRef$T$C(Vals)*/, new StringRef(), new OptionalUInt(JD$T$C$R.INSTANCE, Code));
  }
  //template <typename Container = ArrayRef<unsigned int>> 
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::EmitRecord">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 415,
   FQN="llvm::BitstreamWriter::EmitRecord", NM="_ZN4llvm15BitstreamWriter10EmitRecordINS_8ArrayRefIyEEEEvjRKT_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter10EmitRecordINS_8ArrayRefIyEEEEvjRKT_j")
  //</editor-fold>
  public void EmitRecord(/*uint*/int Code, final /*const*/ArrayRefUInt /*&*/ Vals) {
    EmitRecord(Code, Vals, 0);
  }
  public void EmitRecord(/*uint*/int Code, final /*const*/ArrayRefUInt /*&*/ Vals, /*uint*/int Abbrev/*= 0*/) {
    if (!(Abbrev != 0)) {
      /*uint32_t*/int Count = Vals.size();//(/*static_cast*//*uint32_t*/int)(makeArrayRef_ArrayRef$T$C(Vals).size()));
      EmitCode(FixedAbbrevIDs.UNABBREV_RECORD);
      EmitVBR(Code, 6);
      EmitVBR(Count, 6);
      for (/*uint*/int i = 0, e = Count; i != e; ++i)  {
        EmitVBR64($uint2ulong(Vals.$at(i)), 6);
      }
      return;
    }

    EmitRecordWithAbbrevImpl$UInt(Abbrev, Vals/*makeArrayRef_ArrayRef$T$C(Vals)*/, new StringRef(), new OptionalUInt(JD$T$C$R.INSTANCE, Code));
  }
//  /*template <typename Container> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::EmitRecord">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 415,
//   FQN="llvm::BitstreamWriter::EmitRecord", NM="Tpl__ZN4llvm15BitstreamWriter10EmitRecordEjRKT_j",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=Tpl__ZN4llvm15BitstreamWriter10EmitRecordEjRKT_j")
//  //</editor-fold>
//  public </*typename*/ Container> void EmitRecord(/*uint*/int Code, final /*const*/ Container /*&*/ Vals) {
//    EmitRecord(Code, Vals, 0);
//  }
//  public </*typename*/ Container> void EmitRecord(/*uint*/int Code, final /*const*/ Container /*&*/ Vals, /*uint*/int Abbrev/*= 0*/) {
//    if (!(Abbrev != 0)) {
//      /*uint32_t*/int Count = ((/*static_cast*//*uint32_t*/int)(makeArrayRef(Vals).size()));
//      EmitCode(bitc.FixedAbbrevIDs.UNABBREV_RECORD.getValue());
//      EmitVBR(Code, 6);
//      EmitVBR(Count, 6);
//      for (/*uint*/int i = 0, e = Count; i != e; ++i)  {
//        EmitVBR64(Vals[i], 6);
//      }
//      return;
//    }
//
//    EmitRecordWithAbbrevImpl(Abbrev, makeArrayRef(Vals), new StringRef(), Code);
//  }
  
  
  /// EmitRecordWithAbbrev - Emit a record with the specified abbreviation.
  /// Unlike EmitRecord, the code for the record should be included in Vals as
  /// the first entry.
  /*template <typename Container> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::EmitRecordWithAbbrev">
  @Converted(kind = Converted.Kind.MANUAL_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 435,
   FQN="llvm::BitstreamWriter::EmitRecordWithAbbrev", NM="Tpl__ZN4llvm15BitstreamWriter20EmitRecordWithAbbrevEjRKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=Tpl__ZN4llvm15BitstreamWriter20EmitRecordWithAbbrevEjRKT_")
  //</editor-fold>
  public </*typename*/ Container> void EmitRecordWithAbbrev(/*uint*/int Abbrev, /*const*/ Container /*&*/ Vals) {
    throw new UnsupportedOperationException("Use one of EmitRecordWithAbbrev specializations or add new one for " + NativeTrace.getIdentityStr(Vals));
  }
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::EmitRecordWithAbbrev">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 435,
   FQN="llvm::BitstreamWriter::EmitRecordWithAbbrev", NM="_ZN4llvm15BitstreamWriter20EmitRecordWithAbbrevIA2_yEEvjRKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter20EmitRecordWithAbbrevIA2_yEEvjRKT_")
  //</editor-fold>
  public void EmitRecordWithAbbrev(/*uint*/int Abbrev, final /*ullong*/SmallVectorImplULong /*const*/ /*&*/ Vals) {
    EmitRecordWithAbbrevImpl$ULLong(Abbrev, makeArrayRef$ULong(Vals), new StringRef(), new OptionalUInt(None));
  }
  public void EmitRecordWithAbbrev(/*uint*/int Abbrev, final /*ullong*/long /*const*/ /*&*/ Vals[]) {
    EmitRecordWithAbbrevImpl$ULLong(Abbrev, makeArrayRef$ULLong(Vals), new StringRef(), new OptionalUInt(None));
  }
  
  
  /// EmitRecordWithBlob - Emit the specified record to the stream, using an
  /// abbrev that includes a blob at the end.  The blob data to emit is
  /// specified by the pointer and length specified at the end.  In contrast to
  /// EmitRecord, this routine expects that the first entry in Vals is the code
  /// of the record.
  /*template <typename Container> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::EmitRecordWithBlob">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 445,
   FQN="llvm::BitstreamWriter::EmitRecordWithBlob", NM="Tpl__ZN4llvm15BitstreamWriter18EmitRecordWithBlobEjRKT_NS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=Tpl__ZN4llvm15BitstreamWriter18EmitRecordWithBlobEjRKT_NS_9StringRefE")
  //</editor-fold>
  public </*typename*/ Container> void EmitRecordWithBlob(/*uint*/int Abbrev, final /*const*/ Container /*&*/ Vals, 
                    StringRef Blob) {
    throw new UnsupportedOperationException("Use or add one of specialized for Vals methods EmitRecordWithBlob(Abbrev. Vals, Blob)" + NativeTrace.getIdentityStr(Vals));
  }
  //template <typename Container = SmallVectorImpl<unsigned long long>> 
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::EmitRecordWithBlob">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 445,
   FQN="llvm::BitstreamWriter::EmitRecordWithBlob", NM="_ZN4llvm15BitstreamWriter18EmitRecordWithBlobINS_15SmallVectorImplIyEEEEvjRKT_NS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter18EmitRecordWithBlobINS_15SmallVectorImplIyEEEEvjRKT_NS_9StringRefE")
  //</editor-fold>
  public void EmitRecordWithBlob(/*uint*/int Abbrev, final /*const*/SmallVectorImplULong /*&*/ Vals, 
                    StringRef Blob) {
    EmitRecordWithAbbrevImpl$ULLong(Abbrev, makeArrayRef$ULLong(Vals), new StringRef(Blob), new OptionalUInt(None));
  }
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 445,
   FQN="llvm::BitstreamWriter::EmitRecordWithBlob", NM="_ZN4llvm15BitstreamWriter18EmitRecordWithBlobINS_15SmallVectorImplIyEEEEvjRKT_NS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter18EmitRecordWithBlobINS_15SmallVectorImplIyEEEEvjRKT_NS_9StringRefE")
  //</editor-fold>
  public void EmitRecordWithBlob(/*uint*/int Abbrev, final /*const*/long /*&*/ Vals[], 
                    StringRef Blob) {
    EmitRecordWithAbbrevImpl$ULLong(Abbrev, makeArrayRef$ULLong(Vals, Vals.length), new StringRef(Blob), new OptionalUInt(None));
  }  
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 445,
   FQN="llvm::BitstreamWriter::EmitRecordWithBlob", NM="_ZN4llvm15BitstreamWriter18EmitRecordWithBlobINS_15SmallVectorImplIyEEEEvjRKT_NS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter18EmitRecordWithBlobINS_15SmallVectorImplIyEEEEvjRKT_NS_9StringRefE")
  //</editor-fold>
  public void EmitRecordWithBlob(/*uint*/int Abbrev, final /*const*/ArrayRefULong /*&*/ Vals, 
                    StringRef Blob) {
    EmitRecordWithAbbrevImpl$ULLong(Abbrev, Vals, new StringRef(Blob), new OptionalUInt(None));
  }

  /*template <typename Container> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::EmitRecordWithBlob">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 450,
   FQN="llvm::BitstreamWriter::EmitRecordWithBlob", NM="Tpl__ZN4llvm15BitstreamWriter18EmitRecordWithBlobEjRKT_PKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=Tpl__ZN4llvm15BitstreamWriter18EmitRecordWithBlobEjRKT_PKcj")
  //</editor-fold>
  public </*typename*/ Container> void EmitRecordWithBlob(/*uint*/int Abbrev, final /*const*/ Container /*&*/ Vals, 
                    /*const*/char$ptr/*char P*/ BlobData, /*uint*/int BlobLen) {
    throw new UnsupportedOperationException("Use or add version with specialized Vals parameter EmitRecordWithBlob(Abbrev, ???, BlobData, BlobLen): " + NativeTrace.getIdentityStr(Vals));
  }
  public void EmitRecordWithBlob(/*uint*/int Abbrev, final/*const*/long /*&*/ Vals[], 
                    /*const*/char$ptr/*char P*/ BlobData, /*uint*/int BlobLen) {
    EmitRecordWithBlob(Abbrev, Vals, new StringRef(BlobData, BlobLen));
  }  
  public void EmitRecordWithBlob(/*uint*/int Abbrev, final/*const*/SmallVectorImplULong /*&*/ Vals, 
                    /*const*/char$ptr/*char P*/ BlobData, /*uint*/int BlobLen) {
    EmitRecordWithBlob(Abbrev, Vals, new StringRef(BlobData, BlobLen));
  }  
  public void EmitRecordWithBlob(/*uint*/int Abbrev, final/*const*/ArrayRefULong /*&*/ Vals, 
                    /*const*/char$ptr/*char P*/ BlobData, /*uint*/int BlobLen) {
    EmitRecordWithBlob(Abbrev, Vals, new StringRef(BlobData, BlobLen));
  }

  
  /// EmitRecordWithArray - Just like EmitRecordWithBlob, works with records
  /// that end with an array.
  /*template <typename Container> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::EmitRecordWithArray">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 459,
   FQN="llvm::BitstreamWriter::EmitRecordWithArray", NM="Tpl__ZN4llvm15BitstreamWriter19EmitRecordWithArrayEjRKT_NS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=Tpl__ZN4llvm15BitstreamWriter19EmitRecordWithArrayEjRKT_NS_9StringRefE")
  //</editor-fold>
  public </*typename*/ Container> void EmitRecordWithArray(/*uint*/int Abbrev, final /*const*/ Container /*&*/ Vals, 
                     StringRef Array) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /*template <typename Container> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::EmitRecordWithArray">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 464,
   FQN="llvm::BitstreamWriter::EmitRecordWithArray", NM="Tpl__ZN4llvm15BitstreamWriter19EmitRecordWithArrayEjRKT_PKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=Tpl__ZN4llvm15BitstreamWriter19EmitRecordWithArrayEjRKT_PKcj")
  //</editor-fold>
  public </*typename*/ Container> void EmitRecordWithArray(/*uint*/int Abbrev, final /*const*/ Container /*&*/ Vals, 
                     /*const*/char$ptr/*char P*/ ArrayData, /*uint*/int ArrayLen) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //===--------------------------------------------------------------------===//
  // Abbrev Emission
  //===--------------------------------------------------------------------===//
  /*private:*/
  // Emit the abbreviation as a DEFINE_ABBREV record.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::EncodeAbbrev">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 476,
   FQN="llvm::BitstreamWriter::EncodeAbbrev", NM="_ZN4llvm15BitstreamWriter12EncodeAbbrevEPNS_13BitCodeAbbrevE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter12EncodeAbbrevEPNS_13BitCodeAbbrevE")
  //</editor-fold>
  private void EncodeAbbrev(BitCodeAbbrev /*P*/ Abbv) {
    EmitCode(FixedAbbrevIDs.DEFINE_ABBREV);
    EmitVBR(Abbv.getNumOperandInfos(), 5);
    for (/*uint*/int i = 0, e = ((/*static_cast*//*uint*/int)(Abbv.getNumOperandInfos()));
         i != e; ++i) {
      final /*const*/ BitCodeAbbrevOp /*&*/ Op = Abbv.getOperandInfo(i);
      Emit((Op.isLiteral() ? 1 : 0), 1);
      if (Op.isLiteral()) {
        EmitVBR64(Op.getLiteralValue(), 8);
      } else {
        Emit(Op.getEncoding().getValue(), 3);
        if (Op.hasEncodingData()) {
          EmitVBR64(Op.getEncodingData(), 5);
        }
      }
    }
  }

/*public:*/
  
  /// EmitAbbrev - This emits an abbreviation to the stream.  Note that this
  /// method takes ownership of the specified abbrev.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::EmitAbbrev">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 496,
   FQN="llvm::BitstreamWriter::EmitAbbrev", NM="_ZN4llvm15BitstreamWriter10EmitAbbrevEPNS_13BitCodeAbbrevE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter10EmitAbbrevEPNS_13BitCodeAbbrevE")
  //</editor-fold>
  public /*uint*/int EmitAbbrev(BitCodeAbbrev /*P*/ Abbv) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Emit the abbreviation as a record.
      EncodeAbbrev(Abbv);
      CurAbbrevs.push_back_T$RR($c$.track(new IntrusiveRefCntPtr<BitCodeAbbrev>(Abbv))); $c$.clean();
      return ((/*static_cast*//*uint*/int)(CurAbbrevs.size())) - 1
         + FixedAbbrevIDs.FIRST_APPLICATION_ABBREV;
    } finally {
      $c$.$destroy();
    }
  }

  
  //===--------------------------------------------------------------------===//
  // BlockInfo Block Emission
  //===--------------------------------------------------------------------===//
  
  /// EnterBlockInfoBlock - Start emitting the BLOCKINFO_BLOCK.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::EnterBlockInfoBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 509,
   FQN="llvm::BitstreamWriter::EnterBlockInfoBlock", NM="_ZN4llvm15BitstreamWriter19EnterBlockInfoBlockEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter19EnterBlockInfoBlockEj")
  //</editor-fold>
  public void EnterBlockInfoBlock(/*uint*/int CodeWidth) {
    EnterSubblock(StandardBlockIDs.BLOCKINFO_BLOCK_ID, CodeWidth);
    BlockInfoCurBID = ~0/*U*/;
  }

/*private:*/
  /// SwitchToBlockID - If we aren't already talking about the specified block
  /// ID, emit a BLOCKINFO_CODE_SETBID record.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::SwitchToBlockID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 516,
   FQN="llvm::BitstreamWriter::SwitchToBlockID", NM="_ZN4llvm15BitstreamWriter15SwitchToBlockIDEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter15SwitchToBlockIDEj")
  //</editor-fold>
  private void SwitchToBlockID(/*uint*/int BlockID) {
    if (BlockInfoCurBID == BlockID) {
      return;
    }
    SmallVectorUInt V/*J*/= new SmallVectorUInt(2, 0);
    V.push_back(BlockID);
    EmitRecord(BlockInfoCodes.BLOCKINFO_CODE_SETBID.getValue(), V);
    BlockInfoCurBID = BlockID;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::getOrCreateBlockInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 524,
   FQN="llvm::BitstreamWriter::getOrCreateBlockInfo", NM="_ZN4llvm15BitstreamWriter20getOrCreateBlockInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter20getOrCreateBlockInfoEj")
  //</editor-fold>
  private BlockInfo /*&*/ getOrCreateBlockInfo(/*uint*/int BlockID) {
    {
      BlockInfo /*P*/ BI = getBlockInfo(BlockID);
      if ((BI != null)) {
        return $Deref(BI);
      }
    }
    
    // Otherwise, add a new record.
    BlockInfoRecords.emplace_back(new BlockInfo());
    BlockInfoRecords.back().BlockID = BlockID;
    return BlockInfoRecords.back();
  }

/*public:*/
  
  /// EmitBlockInfoAbbrev - Emit a DEFINE_ABBREV record for the specified
  /// BlockID.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamWriter::EmitBlockInfoAbbrev">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamWriter.h", line = 538,
   FQN="llvm::BitstreamWriter::EmitBlockInfoAbbrev", NM="_ZN4llvm15BitstreamWriter19EmitBlockInfoAbbrevEjPNS_13BitCodeAbbrevE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm15BitstreamWriter19EmitBlockInfoAbbrevEjPNS_13BitCodeAbbrevE")
  //</editor-fold>
  public /*uint*/int EmitBlockInfoAbbrev(/*uint*/int BlockID, BitCodeAbbrev /*P*/ Abbv) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SwitchToBlockID(BlockID);
      EncodeAbbrev(Abbv);
      
      // Add the abbrev to the specified block record.
      final BlockInfo /*&*/ Info = getOrCreateBlockInfo(BlockID);
      Info.Abbrevs.push_back_T$RR($c$.track(new IntrusiveRefCntPtr<BitCodeAbbrev>(Abbv))); $c$.clean();
      
      return Info.Abbrevs.size() - 1 + FixedAbbrevIDs.FIRST_APPLICATION_ABBREV;
    } finally {
      $c$.$destroy();
    }
  }

  
  @Override public String toString() {
    return "" + "Out=" + Out // NOI18N
              + ", CurBit=" + CurBit // NOI18N
              + ", CurValue=" + CurValue // NOI18N
              + ", CurCodeSize=" + CurCodeSize // NOI18N
              + ", BlockInfoCurBID=" + BlockInfoCurBID // NOI18N
              + ", CurAbbrevs=" + CurAbbrevs // NOI18N
              + ", BlockScope=" + BlockScope // NOI18N
              + ", BlockInfoRecords=" + BlockInfoRecords; // NOI18N
  }
}
