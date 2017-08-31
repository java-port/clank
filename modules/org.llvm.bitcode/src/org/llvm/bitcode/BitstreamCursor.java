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
import static org.clank.support.Casts.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.bitcode.bitc.*;
import org.llvm.bitcode.java.BitcodeJavaDifferentiators.JD$BitstreamReader$P;
import static org.llvm.bitcode.reader.impl.BitstreamReaderStatics.*;


/// This represents a position within a bitcode file, implemented on top of a
/// SimpleBitstreamCursor.
///
/// Unlike iterators, BitstreamCursors are heavy-weight objects that should not
/// be passed by value.
//<editor-fold defaultstate="collapsed" desc="llvm::BitstreamCursor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 413,
 FQN="llvm::BitstreamCursor", NM="_ZN4llvm15BitstreamCursorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm15BitstreamCursorE")
//</editor-fold>
public class BitstreamCursor extends /**/ SimpleBitstreamCursor implements NativeCloneable<BitstreamCursor>, Destructors.ClassWithDestructor {
  // This is the declared size of code values used for the current block, in
  // bits.
  private /*uint*/int CurCodeSize/* = 2*/;
  
  /// Abbrevs installed at in this block.
  private std.vector<IntrusiveRefCntPtr<BitCodeAbbrev>> CurAbbrevs;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamCursor::Block">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 421,
   FQN="llvm::BitstreamCursor::Block", NM="_ZN4llvm15BitstreamCursor5BlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm15BitstreamCursor5BlockE")
  //</editor-fold>
  private static class/*struct*/ Block implements NativePOD<Block>, Destructors.ClassWithDestructor {
    public /*uint*/int PrevCodeSize;
    public std.vector<IntrusiveRefCntPtr<BitCodeAbbrev>> PrevAbbrevs;
    //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamCursor::Block::Block">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 424,
     FQN="llvm::BitstreamCursor::Block::Block", NM="_ZN4llvm15BitstreamCursor5BlockC1Ej",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm15BitstreamCursor5BlockC1Ej")
    //</editor-fold>
    public /*explicit*/ Block(/*uint*/int PCS) {
      // : PrevCodeSize(PCS), PrevAbbrevs() 
      //START JInit
      this.PrevCodeSize = PCS;
      this.PrevAbbrevs = new std.vector<IntrusiveRefCntPtr<BitCodeAbbrev>>(new IntrusiveRefCntPtr<BitCodeAbbrev>());
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamCursor::Block::Block">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 421,
     FQN="llvm::BitstreamCursor::Block::Block", NM="_ZN4llvm15BitstreamCursor5BlockC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm15BitstreamCursor5BlockC1EOS1_")
    //</editor-fold>
    public /*inline*/ Block(JD$Move _dparam, final Block /*&&*/$Prm0) {
      // : PrevCodeSize(static_cast<Block &&>().PrevCodeSize), PrevAbbrevs(static_cast<Block &&>().PrevAbbrevs) 
      //START JInit
      this.PrevCodeSize = $Prm0.PrevCodeSize;
      this.PrevAbbrevs = new std.vector<IntrusiveRefCntPtr<BitCodeAbbrev>>(JD$Move.INSTANCE, $Prm0.PrevAbbrevs);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamCursor::Block::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 421,
     FQN="llvm::BitstreamCursor::Block::operator=", NM="_ZN4llvm15BitstreamCursor5BlockaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm15BitstreamCursor5BlockaSEOS1_")
    //</editor-fold>
    public /*inline*/ Block /*&*/ $assignMove(final Block /*&&*/$Prm0) {
      this.PrevCodeSize = $Prm0.PrevCodeSize;
      this.PrevAbbrevs.$assignMove($Prm0.PrevAbbrevs);
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamCursor::Block::~Block">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 421,
     FQN="llvm::BitstreamCursor::Block::~Block", NM="_ZN4llvm15BitstreamCursor5BlockD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm15BitstreamCursor5BlockD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      PrevAbbrevs.$destroy();
      //END JDestroy
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamCursor::Block::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 421,
     FQN="llvm::BitstreamCursor::Block::operator=", NM="_ZN4llvm15BitstreamCursor5BlockaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm15BitstreamCursor5BlockaSERKS1_")
    //</editor-fold>
    public /*inline*/ Block /*&*/ $assign(final /*const*/ Block /*&*/ $Prm0) {
      this.PrevCodeSize = $Prm0.PrevCodeSize;
      this.PrevAbbrevs.$assign($Prm0.PrevAbbrevs);
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamCursor::Block::Block">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 421,
     FQN="llvm::BitstreamCursor::Block::Block", NM="_ZN4llvm15BitstreamCursor5BlockC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm15BitstreamCursor5BlockC1ERKS1_")
    //</editor-fold>
    public /*inline*/ Block(final /*const*/ Block /*&*/ $Prm0) {
      // : PrevCodeSize(.PrevCodeSize), PrevAbbrevs(.PrevAbbrevs) 
      //START JInit
      this.PrevCodeSize = $Prm0.PrevCodeSize;
      this.PrevAbbrevs = new std.vector<IntrusiveRefCntPtr<BitCodeAbbrev>>($Prm0.PrevAbbrevs);
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    Block() {
      this.PrevAbbrevs = new std.vector<IntrusiveRefCntPtr<BitCodeAbbrev>>(new IntrusiveRefCntPtr<BitCodeAbbrev>());
      this.PrevCodeSize = 0;
    }
    
    @Override public Block clone() {
      return new Block(this);
    }


    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "PrevCodeSize=" + PrevCodeSize // NOI18N
                + ", PrevAbbrevs=" + PrevAbbrevs; // NOI18N
    }
  };
  
  /// This tracks the codesize of parent blocks.
  private SmallVector<Block> BlockScope;
/*public:*/
  public static /*const*//*size_t*/int MaxChunkSize = $sizeof_UInt() * 8;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamCursor::BitstreamCursor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 434,
   FQN="llvm::BitstreamCursor::BitstreamCursor", NM="_ZN4llvm15BitstreamCursorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm15BitstreamCursorC1Ev")
  //</editor-fold>
  public BitstreamCursor() {
    // : SimpleBitstreamCursor(), CurCodeSize(2), CurAbbrevs(), BlockScope()/* = default*/ 
    //START JInit
    super();
    /*InClass*/this.CurCodeSize = 2;
    this.CurAbbrevs = new std.vector<IntrusiveRefCntPtr<BitCodeAbbrev>>(new IntrusiveRefCntPtr<BitCodeAbbrev>());
    this.BlockScope = new SmallVector<Block>(8, new Block());
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamCursor::BitstreamCursor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 436,
   FQN="llvm::BitstreamCursor::BitstreamCursor", NM="_ZN4llvm15BitstreamCursorC1ERNS_15BitstreamReaderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm15BitstreamCursorC1ERNS_15BitstreamReaderE")
  //</editor-fold>
  public /*explicit*/ BitstreamCursor(final BitstreamReader /*&*/ R) {
    // : SimpleBitstreamCursor(), CurCodeSize(2), CurAbbrevs(), BlockScope() 
    //START JInit
    super();
    /*InClass*/this.CurCodeSize = 2;
    this.CurAbbrevs = new std.vector<IntrusiveRefCntPtr<BitCodeAbbrev>>(new IntrusiveRefCntPtr<BitCodeAbbrev>());
    this.BlockScope = new SmallVector<Block>(8, new Block());
    //END JInit
    init($AddrOf(R));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamCursor::init">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 438,
   FQN="llvm::BitstreamCursor::init", NM="_ZN4llvm15BitstreamCursor4initEPNS_15BitstreamReaderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm15BitstreamCursor4initEPNS_15BitstreamReaderE")
  //</editor-fold>
  public void init(BitstreamReader /*P*/ R) {
    freeState();
    super.$assignMove(new SimpleBitstreamCursor(JD$BitstreamReader$P.INSTANCE, R));
    CurCodeSize = 2;
  }

  
  //===----------------------------------------------------------------------===//
  //  BitstreamCursor implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamCursor::freeState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitstreamReader.cpp", line = 18,
   FQN="llvm::BitstreamCursor::freeState", NM="_ZN4llvm15BitstreamCursor9freeStateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitstreamReader.cpp -nm=_ZN4llvm15BitstreamCursor9freeStateEv")
  //</editor-fold>
  public void freeState() {
    // Free all the Abbrevs.
    CurAbbrevs.clear();
    
    // Free all the Abbrevs in the block scope.
    BlockScope.clear();
  }


  
  //JAVA: using SimpleBitstreamCursor::canSkipToPos;
  //JAVA: using SimpleBitstreamCursor::AtEndOfStream;
  //JAVA: using SimpleBitstreamCursor::GetCurrentBitNo;
  //JAVA: using SimpleBitstreamCursor::getCurrentByteNo;
  //JAVA: using SimpleBitstreamCursor::getPointerToByte;
  //JAVA: using SimpleBitstreamCursor::getBitStreamReader;
  //JAVA: using SimpleBitstreamCursor::JumpToBit;
  //JAVA: using SimpleBitstreamCursor::fillCurWord;
  //JAVA: using SimpleBitstreamCursor::Read;
  //JAVA: using SimpleBitstreamCursor::ReadVBR;
  //JAVA: using SimpleBitstreamCursor::ReadVBR64;
  
  /// Return the number of bits used to encode an abbrev #.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamCursor::getAbbrevIDWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 459,
   FQN="llvm::BitstreamCursor::getAbbrevIDWidth", NM="_ZNK4llvm15BitstreamCursor16getAbbrevIDWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK4llvm15BitstreamCursor16getAbbrevIDWidthEv")
  //</editor-fold>
  public /*uint*/int getAbbrevIDWidth() /*const*/ {
    return CurCodeSize;
  }

  
  /// Flags that modify the behavior of advance().
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamCursor::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 462,
   FQN="llvm::BitstreamCursor::(anonymous)", NM="_ZN4llvm15BitstreamCursorE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm15BitstreamCursorE_Unnamed_enum")
  //</editor-fold>
  public enum Unnamed_enum implements Native.NativeUIntEnum {
    /// If this flag is used, the advance() method does not automatically pop
    /// the block scope when the end of a block is reached.
    AF_DontPopBlockAtEnd(1),
    
    /// If this flag is used, abbrev entries are returned just like normal
    /// records.
    AF_DontAutoprocessAbbrevs(2);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Unnamed_enum valueOf(int val) {
      Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Unnamed_enum[] VALUES;
      private static final Unnamed_enum[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Unnamed_enum[min < 0 ? (1-min) : 0];
        VALUES = new Unnamed_enum[max >= 0 ? (1+max) : 0];
        for (Unnamed_enum kind : Unnamed_enum.values()) {
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
    private Unnamed_enum(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// Advance the current bitstream, returning the next entry in the stream.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamCursor::advance">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 473,
   FQN="llvm::BitstreamCursor::advance", NM="_ZN4llvm15BitstreamCursor7advanceEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm15BitstreamCursor7advanceEj")
  //</editor-fold>
  public BitstreamEntry advance() {
    return advance(0);
  }
  public BitstreamEntry advance(/*uint*/int Flags/*= 0*/) {
    while (true) {
      /*uint*/int Code = ReadCode();
      if (Code == FixedAbbrevIDs.END_BLOCK) {
        // Pop the end of the block unless Flags tells us not to.
        if (!((Flags & Unnamed_enum.AF_DontPopBlockAtEnd.getValue()) != 0) && ReadBlockEnd()) {
          return BitstreamEntry.getError();
        }
        return BitstreamEntry.getEndBlock();
      }
      if (Code == FixedAbbrevIDs.ENTER_SUBBLOCK) {
        return BitstreamEntry.getSubBlock(ReadSubBlockID());
      }
      if (Code == FixedAbbrevIDs.DEFINE_ABBREV
         && !((Flags & Unnamed_enum.AF_DontAutoprocessAbbrevs.getValue()) != 0)) {
        // We read and accumulate abbrev's, the client can't do anything with
        // them anyway.
        ReadAbbrevRecord();
        continue;
      }
      
      return BitstreamEntry.getRecord(Code);
    }
  }

  
  /// This is a convenience function for clients that don't expect any
  /// subblocks. This just skips over them automatically.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamCursor::advanceSkippingSubblocks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 500,
   FQN="llvm::BitstreamCursor::advanceSkippingSubblocks", NM="_ZN4llvm15BitstreamCursor24advanceSkippingSubblocksEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm15BitstreamCursor24advanceSkippingSubblocksEj")
  //</editor-fold>
  public BitstreamEntry advanceSkippingSubblocks() {
    return advanceSkippingSubblocks(0);
  }
  public BitstreamEntry advanceSkippingSubblocks(/*uint*/int Flags/*= 0*/) {
    while (true) {
      // If we found a normal entry, return it.
      BitstreamEntry Entry = advance(Flags);
      if (Entry.Kind != BitstreamEntry.Unnamed_enum.SubBlock) {
        return Entry;
      }
      
      // If we found a sub-block, just skip over it and check the next entry.
      if (SkipBlock()) {
        return BitstreamEntry.getError();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamCursor::ReadCode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 513,
   FQN="llvm::BitstreamCursor::ReadCode", NM="_ZN4llvm15BitstreamCursor8ReadCodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm15BitstreamCursor8ReadCodeEv")
  //</editor-fold>
  public /*uint*/int ReadCode() {
    return Read(CurCodeSize);
  }

  
  // Block header:
  //    [ENTER_SUBBLOCK, blockid, newcodelen, <align4bytes>, blocklen]
  
  /// Having read the ENTER_SUBBLOCK code, read the BlockID for the block.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamCursor::ReadSubBlockID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 522,
   FQN="llvm::BitstreamCursor::ReadSubBlockID", NM="_ZN4llvm15BitstreamCursor14ReadSubBlockIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm15BitstreamCursor14ReadSubBlockIDEv")
  //</editor-fold>
  public /*uint*/int ReadSubBlockID() {
    return ReadVBR(StandardWidths.BlockIDWidth);
  }

  
  /// Having read the ENTER_SUBBLOCK abbrevid and a BlockID, skip over the body
  /// of this block. If the block record is malformed, return true.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamCursor::SkipBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 528,
   FQN="llvm::BitstreamCursor::SkipBlock", NM="_ZN4llvm15BitstreamCursor9SkipBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm15BitstreamCursor9SkipBlockEv")
  //</editor-fold>
  public boolean SkipBlock() {
    // Read and ignore the codelen value.  Since we are skipping this block, we
    // don't care what code widths are used inside of it.
    ReadVBR(StandardWidths.CodeLenWidth);
    SkipToFourByteBoundary();
    /*uint*/int NumFourBytes = Read(StandardWidths.BlockSizeWidth);
    
    // Check that the block wasn't partially defined, and that the offset isn't
    // bogus.
    /*size_t*/int SkipTo = $ullong2uint(GetCurrentBitNo() + $uint2ullong(NumFourBytes * 4 * 8));
    if (AtEndOfStream() || !canSkipToPos($div_uint(SkipTo, 8))) {
      return true;
    }
    
    JumpToBit($uint2ulong(SkipTo));
    return false;
  }

  
  /// Having read the ENTER_SUBBLOCK abbrevid, enter the block, and return true
  /// if the block has an error.
  
  /// Having read the ENTER_SUBBLOCK abbrevid, enter the block, and return true
  /// if the block has an error.
  
  /// EnterSubBlock - Having read the ENTER_SUBBLOCK abbrevid, enter
  /// the block, and return true if the block has an error.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamCursor::EnterSubBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitstreamReader.cpp", line = 28,
   FQN="llvm::BitstreamCursor::EnterSubBlock", NM="_ZN4llvm15BitstreamCursor13EnterSubBlockEjPj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitstreamReader.cpp -nm=_ZN4llvm15BitstreamCursor13EnterSubBlockEjPj")
  //</editor-fold>
  public boolean EnterSubBlock(/*uint*/int BlockID) {
    return EnterSubBlock(BlockID, (uint$ptr/*uint P*/ )null);
  }
  public boolean EnterSubBlock(/*uint*/int BlockID, uint$ptr/*uint P*/ NumWordsP/*= null*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Save the current block's state on BlockScope.
      BlockScope.push_back_T$RR($c$.track(new Block(CurCodeSize))); $c$.clean();
      BlockScope.back().PrevAbbrevs.swap(CurAbbrevs);
      {
        
        // Add the abbrevs specific to this block to the CurAbbrevs list.
        /*const*/ BitstreamReader.BlockInfo /*P*/ Info = getBitStreamReader().getBlockInfo(BlockID);
        if ((Info != null)) {
          CurAbbrevs.insert$T(new std.vector.iterator</*const*/ IntrusiveRefCntPtr<BitCodeAbbrev> /*P*/ >(CurAbbrevs.end()), Info.Abbrevs.begin$Const(), 
              Info.Abbrevs.end$Const());
        }
      }
      
      // Get the codesize of this block.
      CurCodeSize = ReadVBR(StandardWidths.CodeLenWidth);
      // We can't read more than MaxChunkSize at a time
      if ($greater_uint(CurCodeSize, MaxChunkSize)) {
        return true;
      }
      
      SkipToFourByteBoundary();
      /*uint*/int NumWords = Read(StandardWidths.BlockSizeWidth);
      if (Native.$bool(NumWordsP)) {
        NumWordsP.$set(NumWords);
      }
      
      // Validate that this block is sane.
      return CurCodeSize == 0 || AtEndOfStream();
    } finally {
      $c$.$destroy();
    }
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamCursor::ReadBlockEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 549,
   FQN="llvm::BitstreamCursor::ReadBlockEnd", NM="_ZN4llvm15BitstreamCursor12ReadBlockEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm15BitstreamCursor12ReadBlockEndEv")
  //</editor-fold>
  public boolean ReadBlockEnd() {
    if (BlockScope.empty()) {
      return true;
    }
    
    // Block tail:
    //    [END_BLOCK, <align4bytes>]
    SkipToFourByteBoundary();
    
    popBlockScope();
    return false;
  }

/*private:*/
  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamCursor::popBlockScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 562,
   FQN="llvm::BitstreamCursor::popBlockScope", NM="_ZN4llvm15BitstreamCursor13popBlockScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm15BitstreamCursor13popBlockScopeEv")
  //</editor-fold>
  private void popBlockScope() {
    CurCodeSize = BlockScope.back().PrevCodeSize;
    
    CurAbbrevs.$assignMove(std.move(BlockScope.back().PrevAbbrevs));
    BlockScope.pop_back();
  }


  //===--------------------------------------------------------------------===//
  // Record Processing
  //===--------------------------------------------------------------------===//
  /*public:*/
  /// Return the abbreviation for the specified AbbrevId.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamCursor::getAbbrev">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 575,
   FQN="llvm::BitstreamCursor::getAbbrev", NM="_ZN4llvm15BitstreamCursor9getAbbrevEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm15BitstreamCursor9getAbbrevEj")
  //</editor-fold>
  public /*const*/ BitCodeAbbrev /*P*/ getAbbrev(/*uint*/int AbbrevID) {
    /*uint*/int AbbrevNo = AbbrevID - FixedAbbrevIDs.FIRST_APPLICATION_ABBREV;
    if ($greatereq_uint(AbbrevNo, CurAbbrevs.size())) {
      report_fatal_error($("Invalid abbrev number"));
    }
    return CurAbbrevs.$at(AbbrevNo).get();
  }

  
  /// Read the current record and discard it.
  
  /// Read the current record and discard it.
  
  /// skipRecord - Read the current record and discard it.
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamCursor::skipRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitstreamReader.cpp", line = 101,
   FQN="llvm::BitstreamCursor::skipRecord", NM="_ZN4llvm15BitstreamCursor10skipRecordEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitstreamReader.cpp -nm=_ZN4llvm15BitstreamCursor10skipRecordEj")
  //</editor-fold>
  public void skipRecord(/*uint*/int AbbrevID) {
    // Skip unabbreviated records by reading past their entries.
    if (AbbrevID == FixedAbbrevIDs.UNABBREV_RECORD) {
      /*uint*/int Code = ReadVBR(6);
      ///*J:(void)*/Code;
      /*uint*/int NumElts = ReadVBR(6);
      for (/*uint*/int i = 0; i != NumElts; ++i)  {
        /*J:(void)*/ReadVBR64(6);
      }
      return;
    }
    
    /*const*/ BitCodeAbbrev /*P*/ Abbv = getAbbrev(AbbrevID);
    
    for (/*uint*/int i = 0, e = Abbv.getNumOperandInfos(); i != e; ++i) {
      final /*const*/ BitCodeAbbrevOp /*&*/ Op = Abbv.getOperandInfo(i);
      if (Op.isLiteral()) {
        continue;
      }
      if (Op.getEncoding() != BitCodeAbbrevOp.Encoding.Array
         && Op.getEncoding() != BitCodeAbbrevOp.Encoding.Blob) {
        skipAbbreviatedField(/*Deref*/this, Op);
        continue;
      }
      if (Op.getEncoding() == BitCodeAbbrevOp.Encoding.Array) {
        // Array case.  Read the number of elements as a vbr6.
        /*uint*/int NumElts = ReadVBR(6);
        
        // Get the element encoding.
        assert (i + 2 == e) : "array op not second to last?";
        final /*const*/ BitCodeAbbrevOp /*&*/ EltEnc = Abbv.getOperandInfo(++i);
        
        // Read all the elements.
        // Decode the value as we are commanded.
        switch (EltEnc.getEncoding()) {
         default:
          report_fatal_error($("Array element type can't be an Array or a Blob"));
         case Fixed:
          assert ($lesseq_ulong_uint(Op.getEncodingData(), MaxChunkSize));
          for (; (NumElts != 0); --NumElts)  {
            Read((/*uint*/int)$ulong2uint(EltEnc.getEncodingData()));
          }
          break;
         case VBR:
          assert ($lesseq_ulong_uint(Op.getEncodingData(), MaxChunkSize));
          for (; (NumElts != 0); --NumElts)  {
            ReadVBR64((/*uint*/int)$ulong2uint(EltEnc.getEncodingData()));
          }
          break;
         case Char6:
          for (; (NumElts != 0); --NumElts)  {
            Read(6);
          }
          break;
        }
        continue;
      }
      assert (Op.getEncoding() == BitCodeAbbrevOp.Encoding.Blob);
      // Blob case.  Read the number of bytes as a vbr6.
      /*uint*/int NumElts = ReadVBR(6);
      SkipToFourByteBoundary(); // 32-bit alignment
      
      // Figure out where the end of this blob will be including tail padding.
      /*size_t*/int NewEnd = $ullong2uint(GetCurrentBitNo() + $uint2ullong(((NumElts + 3) & ~3) * 8));
      
      // If this would read off the end of the bitcode file, just set the
      // record to empty and return.
      if (!canSkipToPos($div_uint(NewEnd, 8))) {
        skipToEnd();
        break;
      }
      
      // Skip over the blob.
      JumpToBit($uint2ulong(NewEnd));
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamCursor::readRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitstreamReader.cpp", line = 176,
   FQN="llvm::BitstreamCursor::readRecord", NM="_ZN4llvm15BitstreamCursor10readRecordEjRNS_15SmallVectorImplIyEEPNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitstreamReader.cpp -nm=_ZN4llvm15BitstreamCursor10readRecordEjRNS_15SmallVectorImplIyEEPNS_9StringRefE")
  //</editor-fold>
  public /*uint*/int readRecord(/*uint*/int AbbrevID, 
            final SmallVectorImplULong /*&*/ Vals) {
    return readRecord(AbbrevID, 
            Vals, 
            (StringRef /*P*/ )null);
  }
  public /*uint*/int readRecord(/*uint*/int AbbrevID, 
            final SmallVectorImplULong /*&*/ Vals, 
            StringRef /*P*/ Blob/*= null*/) {
    if (AbbrevID == FixedAbbrevIDs.UNABBREV_RECORD) {
      /*uint*/int Code = ReadVBR(6);
      /*uint*/int NumElts = ReadVBR(6);
      for (/*uint*/int i = 0; i != NumElts; ++i)  {
        Vals.push_back(ReadVBR64(6));
      }
      return Code;
    }
    
    /*const*/ BitCodeAbbrev /*P*/ Abbv = getAbbrev(AbbrevID);
    
    // Read the record code first.
    assert (Abbv.getNumOperandInfos() != 0) : "no record code in abbreviation?";
    final /*const*/ BitCodeAbbrevOp /*&*/ CodeOp = Abbv.getOperandInfo(0);
    /*uint*/int Code;
    if (CodeOp.isLiteral()) {
      Code = $ulong2uint(CodeOp.getLiteralValue());
    } else {
      if (CodeOp.getEncoding() == BitCodeAbbrevOp.Encoding.Array
         || CodeOp.getEncoding() == BitCodeAbbrevOp.Encoding.Blob) {
        report_fatal_error($("Abbreviation starts with an Array or a Blob"));
      }
      Code = $ulong2uint(readAbbreviatedField(/*Deref*/this, CodeOp));
    }
    
    for (/*uint*/int i = 1, e = Abbv.getNumOperandInfos(); i != e; ++i) {
      final /*const*/ BitCodeAbbrevOp /*&*/ Op = Abbv.getOperandInfo(i);
      if (Op.isLiteral()) {
        Vals.push_back(Op.getLiteralValue());
        continue;
      }
      if (Op.getEncoding() != BitCodeAbbrevOp.Encoding.Array
         && Op.getEncoding() != BitCodeAbbrevOp.Encoding.Blob) {
        Vals.push_back(readAbbreviatedField(/*Deref*/this, Op));
        continue;
      }
      if (Op.getEncoding() == BitCodeAbbrevOp.Encoding.Array) {
        // Array case.  Read the number of elements as a vbr6.
        /*uint*/int NumElts = ReadVBR(6);
        
        // Get the element encoding.
        if (i + 2 != e) {
          report_fatal_error($("Array op not second to last"));
        }
        final /*const*/ BitCodeAbbrevOp /*&*/ EltEnc = Abbv.getOperandInfo(++i);
        if (!EltEnc.isEncoding()) {
          report_fatal_error($("Array element type has to be an encoding of a type"));
        }
        
        // Read all the elements.
        switch (EltEnc.getEncoding()) {
         default:
          report_fatal_error($("Array element type can't be an Array or a Blob"));
         case Fixed:
          for (; (NumElts != 0); --NumElts)  {
            Vals.push_back($uint2ullong(Read((/*uint*/int)$ulong2uint(EltEnc.getEncodingData()))));
          }
          break;
         case VBR:
          for (; (NumElts != 0); --NumElts)  {
            Vals.push_back(ReadVBR64((/*uint*/int)$ulong2uint(EltEnc.getEncodingData())));
          }
          break;
         case Char6:
          for (; (NumElts != 0); --NumElts)  {
            Vals.push_back($char2ullong(BitCodeAbbrevOp.DecodeChar6(Read(6))));
          }
        }
        continue;
      }
      assert (Op.getEncoding() == BitCodeAbbrevOp.Encoding.Blob);
      // Blob case.  Read the number of bytes as a vbr6.
      /*uint*/int NumElts = ReadVBR(6);
      SkipToFourByteBoundary(); // 32-bit alignment
      
      // Figure out where the end of this blob will be including tail padding.
      /*size_t*/int CurBitPos = $ulong2uint(GetCurrentBitNo());
      /*size_t*/int NewEnd = CurBitPos + ((NumElts + 3) & ~3) * 8;
      
      // If this would read off the end of the bitcode file, just set the
      // record to empty and return.
      if (!canSkipToPos($div_uint(NewEnd, 8))) {
        Vals.append_size_type$T$value_T$C$R(NumElts, $int2ullong(0));
        skipToEnd();
        break;
      }
      
      // Otherwise, inform the streamer that we need these bytes in memory.  Skip
      // over tail padding first, in case jumping to NewEnd invalidates the Blob
      // pointer.
      JumpToBit($uint2ulong(NewEnd));
      /*const*/char$ptr/*char P*/ Ptr = $tryClone(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, getPointerToBit($uint2ulong(CurBitPos), $uint2ulong(NumElts))));
      
      // If we can return a reference to the data, do so to avoid copying it.
      if ((Blob != null)) {
        $Deref(Blob).$assignMove(new StringRef(Ptr, NumElts));
      } else {
        // Otherwise, unpack into Vals with zero extension.
        for (; (NumElts != 0); --NumElts)  {
          Vals.push_back($uchar2ullong((/*uchar*/byte)Ptr.$postInc().$star()));
        }
      }
    }
    
    return Code;
  }


  
  //===--------------------------------------------------------------------===//
  // Abbrev Processing
  //===--------------------------------------------------------------------===//
  
  //===--------------------------------------------------------------------===//
  // Abbrev Processing
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamCursor::ReadAbbrevRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitstreamReader.cpp", line = 283,
   FQN="llvm::BitstreamCursor::ReadAbbrevRecord", NM="_ZN4llvm15BitstreamCursor16ReadAbbrevRecordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitstreamReader.cpp -nm=_ZN4llvm15BitstreamCursor16ReadAbbrevRecordEv")
  //</editor-fold>
  public void ReadAbbrevRecord() {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      BitCodeAbbrev /*P*/ Abbv = new BitCodeAbbrev();
      /*uint*/int NumOpInfo = ReadVBR(5);
      for (/*uint*/int i = 0; i != NumOpInfo; ++i) {
        boolean IsLiteral = (Read(1) != 0);
        if (IsLiteral) {
          Abbv.Add(new BitCodeAbbrevOp(ReadVBR64(8)));
          continue;
        }
        
        BitCodeAbbrevOp.Encoding E = BitCodeAbbrevOp.Encoding.valueOf(Read(3));
        if (BitCodeAbbrevOp.hasEncodingData(E)) {
          long/*uint64_t*/ Data = ReadVBR64(5);
          
          // As a special case, handle fixed(0) (i.e., a fixed field with zero bits)
          // and vbr(0) as a literal zero.  This is decoded the same way, and avoids
          // a slow path in Read() to have to handle reading zero bits.
          if ((E == BitCodeAbbrevOp.Encoding.Fixed || E == BitCodeAbbrevOp.Encoding.VBR)
             && Data == $int2ullong(0)) {
            Abbv.Add(new BitCodeAbbrevOp($int2ulong(0)));
            continue;
          }
          if ((E == BitCodeAbbrevOp.Encoding.Fixed || E == BitCodeAbbrevOp.Encoding.VBR)
             && $greater_ulong_int$C(Data, MaxChunkSize)) {
            report_fatal_error($("Fixed or VBR abbrev record with size > MaxChunkData"));
          }
          
          Abbv.Add(new BitCodeAbbrevOp(E, Data));
        } else {
          Abbv.Add(new BitCodeAbbrevOp(E));
        }
      }
      if (Abbv.getNumOperandInfos() == 0) {
        report_fatal_error($("Abbrev record with no operands"));
      }
      CurAbbrevs.push_back_T$RR($c$.track(new IntrusiveRefCntPtr<BitCodeAbbrev>(Abbv))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamCursor::ReadBlockInfoBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitstreamReader.cpp", line = 321,
   FQN="llvm::BitstreamCursor::ReadBlockInfoBlock", NM="_ZN4llvm15BitstreamCursor18ReadBlockInfoBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitstreamReader.cpp -nm=_ZN4llvm15BitstreamCursor18ReadBlockInfoBlockEv")
  //</editor-fold>
  public boolean ReadBlockInfoBlock() {
    // If this is the second stream to get to the block info block, skip it.
    if (getBitStreamReader().hasBlockInfoRecords()) {
      return SkipBlock();
    }
    if (EnterSubBlock(StandardBlockIDs.BLOCKINFO_BLOCK_ID)) {
      return true;
    }
    
    SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    BitstreamReader.BlockInfo /*P*/ CurBlockInfo = null;
    
    // Read all the records for this module.
    while (true) {
      BitstreamEntry Entry = advanceSkippingSubblocks(Unnamed_enum.AF_DontAutoprocessAbbrevs.getValue());
      switch (Entry.Kind) {
       case SubBlock: // Handled for us already.
       case Error:
        return true;
       case EndBlock:
        return false;
       case Record:
        // The interesting case.
        break;
      }
      
      // Read abbrev records, associate them with CurBID.
      if (Entry.ID == FixedAbbrevIDs.DEFINE_ABBREV) {
        if (!(CurBlockInfo != null)) {
          return true;
        }
        ReadAbbrevRecord();
        
        // ReadAbbrevRecord installs the abbrev in CurAbbrevs.  Move it to the
        // appropriate BlockInfo.
        CurBlockInfo.Abbrevs.push_back_T$RR(std.move(CurAbbrevs.back()));
        CurAbbrevs.pop_back();
        continue;
      }
      
      // Read a record.
      Record.clear();
      switch (BlockInfoCodes.valueOf(readRecord(Entry.ID, Record))) {
       default:
        break; // Default behavior, ignore unknown content.
       case BLOCKINFO_CODE_SETBID:
        if ($less_uint(Record.size(), 1)) {
          return true;
        }
        CurBlockInfo
           = $AddrOf(getBitStreamReader().getOrCreateBlockInfo((/*uint*/int)$ullong2uint(Record.$at(0))));
        break;
       case BLOCKINFO_CODE_BLOCKNAME:
        {
          if (!(CurBlockInfo != null)) {
            return true;
          }
          if (getBitStreamReader().isIgnoringBlockInfoNames()) {
            break; // Ignore name.
          }
          std.string Name/*J*/= new std.string();
          for (/*uint*/int i = 0, e = Record.size(); i != e; ++i)  {
            Name.$addassign_T((/*char*/byte)$ullong2char(Record.$at(i)));
          }
          CurBlockInfo.Name.$assign(Name);
          break;
        }
       case BLOCKINFO_CODE_SETRECORDNAME:
        {
          if (!(CurBlockInfo != null)) {
            return true;
          }
          if (getBitStreamReader().isIgnoringBlockInfoNames()) {
            break; // Ignore name.
          }
          std.string Name/*J*/= new std.string();
          for (/*uint*/int i = 1, e = Record.size(); i != e; ++i)  {
            Name.$addassign_T((/*char*/byte)$ullong2char(Record.$at(i)));
          }
          CurBlockInfo.RecordNames.push_back_T$RR(std.make_pair_uint_T((/*uint*/int)$ullong2uint(Record.$at(0)), $Clone(Name)
                  ));
          break;
        }
      }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamCursor::BitstreamCursor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 413,
   FQN="llvm::BitstreamCursor::BitstreamCursor", NM="_ZN4llvm15BitstreamCursorC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm15BitstreamCursorC1EOS0_")
  //</editor-fold>
  public /*inline*/ BitstreamCursor(JD$Move _dparam, final BitstreamCursor /*&&*/$Prm0) {
    // : SimpleBitstreamCursor(static_cast<BitstreamCursor &&>()), CurCodeSize(static_cast<BitstreamCursor &&>().CurCodeSize), CurAbbrevs(static_cast<BitstreamCursor &&>().CurAbbrevs), BlockScope(static_cast<BitstreamCursor &&>().BlockScope) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    this.CurCodeSize = $Prm0.CurCodeSize;
    this.CurAbbrevs = new std.vector<IntrusiveRefCntPtr<BitCodeAbbrev>>(JD$Move.INSTANCE, $Prm0.CurAbbrevs);
    this.BlockScope = new SmallVector<Block>(JD$Move.INSTANCE, $Prm0.BlockScope);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamCursor::~BitstreamCursor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 413,
   FQN="llvm::BitstreamCursor::~BitstreamCursor", NM="_ZN4llvm15BitstreamCursorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm15BitstreamCursorD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    BlockScope.$destroy();
    CurAbbrevs.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamCursor::BitstreamCursor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 413,
   FQN="llvm::BitstreamCursor::BitstreamCursor", NM="_ZN4llvm15BitstreamCursorC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm15BitstreamCursorC1ERKS0_")
  //</editor-fold>
  public /*inline*/ BitstreamCursor(final /*const*/ BitstreamCursor /*&*/ $Prm0) {
    // : SimpleBitstreamCursor(), CurCodeSize(.CurCodeSize), CurAbbrevs(.CurAbbrevs), BlockScope(.BlockScope) 
    //START JInit
    super($Prm0);
    this.CurCodeSize = $Prm0.CurCodeSize;
    this.CurAbbrevs = new std.vector<IntrusiveRefCntPtr<BitCodeAbbrev>>($Prm0.CurAbbrevs);
    this.BlockScope = new SmallVector<Block>($Prm0.BlockScope);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamCursor::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 413,
   FQN="llvm::BitstreamCursor::operator=", NM="_ZN4llvm15BitstreamCursoraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN4llvm15BitstreamCursoraSERKS0_")
  //</editor-fold>
  public /*inline*/ BitstreamCursor /*&*/ $assign(final /*const*/ BitstreamCursor /*&*/ $Prm0) {
    /*J:ToBase*/super.$assign($Prm0);
    this.CurCodeSize = $Prm0.CurCodeSize;
    this.CurAbbrevs.$assign($Prm0.CurAbbrevs);
    this.BlockScope.$assign($Prm0.BlockScope);
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public BitstreamCursor clone() {
    return new BitstreamCursor(this);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "CurCodeSize=" + CurCodeSize // NOI18N
              + ", CurAbbrevs=" + CurAbbrevs // NOI18N
              + ", BlockScope=" + BlockScope // NOI18N
              + super.toString(); // NOI18N
  }
}
