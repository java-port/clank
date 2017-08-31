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
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.llvm.support.AdtsupportLlvmGlobals.getNonStreamedMemoryObject;


/// This class is used to read from an LLVM bitcode stream, maintaining
/// information that is global to decoding the entire file. While a file is
/// being read, multiple cursors can be independently advanced or skipped around
/// within the file.  These are represented by the BitstreamCursor class.
//<editor-fold defaultstate="collapsed" desc="llvm::BitstreamReader">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 32,
 FQN="llvm::BitstreamReader", NM="_ZN4llvm15BitstreamReaderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm15BitstreamReaderE")
//</editor-fold>
public class BitstreamReader implements Destructors.ClassWithDestructor {
/*public:*/
  /// This contains information emitted to BLOCKINFO_BLOCK blocks. These
  /// describe abbreviations that all blocks of the specified ID inherit.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamReader::BlockInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 36,
   FQN="llvm::BitstreamReader::BlockInfo", NM="_ZN4llvm15BitstreamReader9BlockInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm15BitstreamReader9BlockInfoE")
  //</editor-fold>
  public static class/*struct*/ BlockInfo implements Destructors.ClassWithDestructor, NativeCloneable<BlockInfo>, NativeMoveable<BlockInfo> {
    public /*uint*/int BlockID;
    public std.vector<IntrusiveRefCntPtr<BitCodeAbbrev>> Abbrevs;
    public std.string Name;
    
    public std.vector<std.pairUIntType<std.string>> RecordNames;
    //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamReader::BlockInfo::BlockInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 36,
     FQN="llvm::BitstreamReader::BlockInfo::BlockInfo", NM="_ZN4llvm15BitstreamReader9BlockInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm15BitstreamReader9BlockInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ BlockInfo(JD$Move _dparam, final BlockInfo /*&&*/$Prm0) {
      // : BlockID(static_cast<BlockInfo &&>().BlockID), Abbrevs(static_cast<BlockInfo &&>().Abbrevs), Name(static_cast<BlockInfo &&>().Name), RecordNames(static_cast<BlockInfo &&>().RecordNames) 
      //START JInit
      this.BlockID = $Prm0.BlockID;
      this.Abbrevs = new std.vector<IntrusiveRefCntPtr<BitCodeAbbrev>>(JD$Move.INSTANCE, $Prm0.Abbrevs);
      this.Name = new std.string(JD$Move.INSTANCE, $Prm0.Name);
      this.RecordNames = new std.vector<std.pairUIntType<std.string>>(JD$Move.INSTANCE, $Prm0.RecordNames);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamReader::BlockInfo::~BlockInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 36,
     FQN="llvm::BitstreamReader::BlockInfo::~BlockInfo", NM="_ZN4llvm15BitstreamReader9BlockInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm15BitstreamReader9BlockInfoD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      RecordNames.$destroy();
      Name.$destroy();
      Abbrevs.$destroy();
      //END JDestroy
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamReader::BlockInfo::BlockInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 36,
     FQN="llvm::BitstreamReader::BlockInfo::BlockInfo", NM="_ZN4llvm15BitstreamReader9BlockInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm15BitstreamReader9BlockInfoC1Ev")
    //</editor-fold>
    public /*inline*/ BlockInfo() {
      // : Abbrevs(), Name(), RecordNames() 
      //START JInit
      this.Abbrevs = new std.vector<IntrusiveRefCntPtr<BitCodeAbbrev>>(new IntrusiveRefCntPtr<BitCodeAbbrev>());
      this.Name = new std.string();
      this.RecordNames = new std.vector<std.pairUIntType<std.string>>(new std.pairUIntType<std.string>());
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN
    
    @Override
    public BlockInfo clone() {
      assert this.Name.empty(): "Expected to clone only empty default-values for collections " + this.Name.toJavaString();
      assert this.BlockID == 0: "Expected to clone only empty default-values for collections " + this.Name.toJavaString();
      assert this.Abbrevs.empty(): "Expected to clone only empty default-values for collections " + this.Name.toJavaString();
      assert this.RecordNames.empty(): "Expected to clone only empty default-values for collections " + this.Name.toJavaString();
      return new BlockInfo();
    }

    @Override
    public BlockInfo move() {
      return new BlockInfo(JD$Move.INSTANCE, this);
    }

  
    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "BlockID=" + BlockID // NOI18N
                + ", Abbrevs=" + Abbrevs // NOI18N
                + ", Name=" + Name // NOI18N
                + ", RecordNames=" + RecordNames; // NOI18N
    }
  };
/*private:*/
  private std.unique_ptr<MemoryObject> BitcodeBytes;
  
  private std.vector<BlockInfo> BlockInfoRecords;
  
  /// This is set to true if we don't care about the block/record name
  /// information in the BlockInfo block. Only llvm-bcanalyzer uses this.
  private boolean IgnoreBlockInfoNames;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamReader::BitstreamReader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 52,
   FQN="llvm::BitstreamReader::BitstreamReader", NM="_ZN4llvm15BitstreamReaderC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm15BitstreamReaderC1ERKS0_")
  //</editor-fold>
  protected/*private*/ BitstreamReader(final /*const*/ BitstreamReader /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamReader::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 53,
   FQN="llvm::BitstreamReader::operator=", NM="_ZN4llvm15BitstreamReaderaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm15BitstreamReaderaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ BitstreamReader /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamReader::BitstreamReader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 55,
   FQN="llvm::BitstreamReader::BitstreamReader", NM="_ZN4llvm15BitstreamReaderC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm15BitstreamReaderC1Ev")
  //</editor-fold>
  public BitstreamReader() {
    // : BitcodeBytes(), BlockInfoRecords(), IgnoreBlockInfoNames(true) 
    //START JInit
    this.BitcodeBytes = new std.unique_ptr<MemoryObject>();
    this.BlockInfoRecords = new std.vector<BlockInfo>(new BlockInfo());
    this.IgnoreBlockInfoNames = true;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamReader::BitstreamReader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 58,
   FQN="llvm::BitstreamReader::BitstreamReader", NM="_ZN4llvm15BitstreamReaderC1EPKhS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm15BitstreamReaderC1EPKhS2_")
  //</editor-fold>
  public BitstreamReader(/*const*/char$ptr/*uchar P*/ Start, /*const*/char$ptr/*uchar P*/ End) {
    // : BitcodeBytes(), BlockInfoRecords(), IgnoreBlockInfoNames(true) 
    //START JInit
    this.BitcodeBytes = new std.unique_ptr<MemoryObject>();
    this.BlockInfoRecords = new std.vector<BlockInfo>(new BlockInfo());
    this.IgnoreBlockInfoNames = true;
    //END JInit
    init(Start, End);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamReader::BitstreamReader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 63,
   FQN="llvm::BitstreamReader::BitstreamReader", NM="_ZN4llvm15BitstreamReaderC1ESt10unique_ptrINS_12MemoryObjectESt14default_deleteIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm15BitstreamReaderC1ESt10unique_ptrINS_12MemoryObjectESt14default_deleteIS2_EE")
  //</editor-fold>
  public BitstreamReader(std.unique_ptr<MemoryObject> BitcodeBytes) {
    // : BitcodeBytes(std::move(BitcodeBytes)), BlockInfoRecords(), IgnoreBlockInfoNames(true) 
    //START JInit
    this.BitcodeBytes = new std.unique_ptr<MemoryObject>(JD$Move.INSTANCE, std.move(BitcodeBytes));
    this.BlockInfoRecords = new std.vector<BlockInfo>(new BlockInfo());
    this.IgnoreBlockInfoNames = true;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamReader::BitstreamReader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 66,
   FQN="llvm::BitstreamReader::BitstreamReader", NM="_ZN4llvm15BitstreamReaderC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm15BitstreamReaderC1EOS0_")
  //</editor-fold>
  public BitstreamReader(JD$Move _dparam, final BitstreamReader /*&&*/Other) {
    // : BitcodeBytes(), BlockInfoRecords() 
    //START JInit
    this.BitcodeBytes = new std.unique_ptr<MemoryObject>();
    this.BlockInfoRecords = new std.vector<BlockInfo>(new BlockInfo());
    //END JInit
    /*Deref*/this.$assignMove(std.move(Other));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamReader::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 70,
   FQN="llvm::BitstreamReader::operator=", NM="_ZN4llvm15BitstreamReaderaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm15BitstreamReaderaSEOS0_")
  //</editor-fold>
  public BitstreamReader /*&*/ $assignMove(final BitstreamReader /*&&*/Other) {
    BitcodeBytes.$assignMove(std.move(Other.BitcodeBytes));
    // Explicitly swap block info, so that nothing gets destroyed twice.
    std.swap(BlockInfoRecords, Other.BlockInfoRecords);
    IgnoreBlockInfoNames = Other.IgnoreBlockInfoNames;
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamReader::init">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 78,
   FQN="llvm::BitstreamReader::init", NM="_ZN4llvm15BitstreamReader4initEPKhS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm15BitstreamReader4initEPKhS2_")
  //</editor-fold>
  public void init(/*const*/char$ptr/*uchar P*/ Start, /*const*/char$ptr/*uchar P*/ End) {
    assert (((End.$sub(Start)) & 3) == 0) : "Bitcode stream not a multiple of 4 bytes";
    BitcodeBytes.reset(getNonStreamedMemoryObject(Start, End));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamReader::getBitcodeBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 83,
   FQN="llvm::BitstreamReader::getBitcodeBytes", NM="_ZN4llvm15BitstreamReader15getBitcodeBytesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm15BitstreamReader15getBitcodeBytesEv")
  //</editor-fold>
  public MemoryObject /*&*/ getBitcodeBytes() {
    return BitcodeBytes.$star();
  }

  
  /// This is called by clients that want block/record name information.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamReader::CollectBlockInfoNames">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 86,
   FQN="llvm::BitstreamReader::CollectBlockInfoNames", NM="_ZN4llvm15BitstreamReader21CollectBlockInfoNamesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm15BitstreamReader21CollectBlockInfoNamesEv")
  //</editor-fold>
  public void CollectBlockInfoNames() {
    IgnoreBlockInfoNames = false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamReader::isIgnoringBlockInfoNames">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 87,
   FQN="llvm::BitstreamReader::isIgnoringBlockInfoNames", NM="_ZN4llvm15BitstreamReader24isIgnoringBlockInfoNamesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm15BitstreamReader24isIgnoringBlockInfoNamesEv")
  //</editor-fold>
  public boolean isIgnoringBlockInfoNames() {
    return IgnoreBlockInfoNames;
  }

  
  //===--------------------------------------------------------------------===//
  // Block Manipulation
  //===--------------------------------------------------------------------===//
  
  /// Return true if we've already read and processed the block info block for
  /// this Bitstream. We only process it for the first cursor that walks over
  /// it.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamReader::hasBlockInfoRecords">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 96,
   FQN="llvm::BitstreamReader::hasBlockInfoRecords", NM="_ZNK4llvm15BitstreamReader19hasBlockInfoRecordsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZNK4llvm15BitstreamReader19hasBlockInfoRecordsEv")
  //</editor-fold>
  public boolean hasBlockInfoRecords() /*const*/ {
    return !BlockInfoRecords.empty();
  }

  
  /// If there is block info for the specified ID, return it, otherwise return
  /// null.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamReader::getBlockInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 100,
   FQN="llvm::BitstreamReader::getBlockInfo", NM="_ZNK4llvm15BitstreamReader12getBlockInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZNK4llvm15BitstreamReader12getBlockInfoEj")
  //</editor-fold>
  public /*const*/ BlockInfo /*P*/ getBlockInfo(/*uint*/int BlockID) /*const*/ {
    // Common case, the most recent entry matches BlockID.
    if (!BlockInfoRecords.empty() && BlockInfoRecords.back$Const().BlockID == BlockID) {
      return $AddrOf(BlockInfoRecords.back$Const());
    }
    
    for (/*uint*/int i = 0, e = ((/*static_cast*//*uint*/int)(BlockInfoRecords.size()));
         i != e; ++i)  {
      if (BlockInfoRecords.$at$Const(i).BlockID == BlockID) {
        return $AddrOf(BlockInfoRecords.$at$Const(i));
      }
    }
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamReader::getOrCreateBlockInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 112,
   FQN="llvm::BitstreamReader::getOrCreateBlockInfo", NM="_ZN4llvm15BitstreamReader20getOrCreateBlockInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm15BitstreamReader20getOrCreateBlockInfoEj")
  //</editor-fold>
  public BlockInfo /*&*/ getOrCreateBlockInfo(/*uint*/int BlockID) {
    {
      /*const*/ BlockInfo /*P*/ BI = getBlockInfo(BlockID);
      if ((BI != null)) {
        return $Deref(((/*const_cast*/BlockInfo /*P*/ )(BI)));
      }
    }
    
    // Otherwise, add a new record.
    BlockInfoRecords.emplace_back(new BlockInfo());
    BlockInfoRecords.back().BlockID = BlockID;
    return BlockInfoRecords.back();
  }

  
  /// Takes block info from the other bitstream reader.
  ///
  /// This is a "take" operation because BlockInfo records are non-trivial, and
  /// indeed rather expensive.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamReader::takeBlockInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 126,
   FQN="llvm::BitstreamReader::takeBlockInfo", NM="_ZN4llvm15BitstreamReader13takeBlockInfoEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm15BitstreamReader13takeBlockInfoEOS0_")
  //</editor-fold>
  public void takeBlockInfo(final BitstreamReader /*&&*/Other) {
    assert (!hasBlockInfoRecords());
    BlockInfoRecords.$assignMove(std.move(Other.BlockInfoRecords));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamReader::~BitstreamReader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 32,
   FQN="llvm::BitstreamReader::~BitstreamReader", NM="_ZN4llvm15BitstreamReaderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN4llvm15BitstreamReaderD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    BlockInfoRecords.$destroy();
    BitcodeBytes.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "BitcodeBytes={" + BitcodeBytes.get() // NOI18N
              + "}, BlockInfoRecords=" + BlockInfoRecords // NOI18N
              + ", IgnoreBlockInfoNames=" + IgnoreBlockInfoNames; // NOI18N
  }
}
