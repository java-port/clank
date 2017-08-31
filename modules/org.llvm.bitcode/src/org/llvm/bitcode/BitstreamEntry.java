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

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;


/// When advancing through a bitstream cursor, each advance can discover a few
/// different kinds of entries:
//<editor-fold defaultstate="collapsed" desc="llvm::BitstreamEntry">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 383,
 FQN="llvm::BitstreamEntry", NM="_ZN4llvm14BitstreamEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitstreamReader.cpp -nm=_ZN4llvm14BitstreamEntryE")
//</editor-fold>
public class/*struct*/ BitstreamEntry {
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamEntry::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 384,
   FQN="llvm::BitstreamEntry::(anonymous)", NM="_ZN4llvm14BitstreamEntryE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitstreamReader.cpp -nm=_ZN4llvm14BitstreamEntryE_Unnamed_enum")
  //</editor-fold>
  public enum Unnamed_enum implements Native.NativeUIntEnum {
    Error(0), // Malformed bitcode was found.
    EndBlock(Error.getValue() + 1), // We've reached the end of the current block, (or the end of the
    // file, which is treated like a series of EndBlock records.
    SubBlock(EndBlock.getValue() + 1), // This is the start of a new subblock of a specific ID.
    Record(SubBlock.getValue() + 1); // This is a record with a specific AbbrevID.

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
  public Unnamed_enum Kind;
  
  public /*uint*/int ID;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamEntry::getError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 394,
   FQN="llvm::BitstreamEntry::getError", NM="_ZN4llvm14BitstreamEntry8getErrorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitstreamReader.cpp -nm=_ZN4llvm14BitstreamEntry8getErrorEv")
  //</editor-fold>
  public static BitstreamEntry getError() {
    BitstreamEntry E/*J*/= new BitstreamEntry();
    E.Kind = Unnamed_enum.Error;
    return E;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamEntry::getEndBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 397,
   FQN="llvm::BitstreamEntry::getEndBlock", NM="_ZN4llvm14BitstreamEntry11getEndBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitstreamReader.cpp -nm=_ZN4llvm14BitstreamEntry11getEndBlockEv")
  //</editor-fold>
  public static BitstreamEntry getEndBlock() {
    BitstreamEntry E/*J*/= new BitstreamEntry();
    E.Kind = Unnamed_enum.EndBlock;
    return E;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamEntry::getSubBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 400,
   FQN="llvm::BitstreamEntry::getSubBlock", NM="_ZN4llvm14BitstreamEntry11getSubBlockEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitstreamReader.cpp -nm=_ZN4llvm14BitstreamEntry11getSubBlockEj")
  //</editor-fold>
  public static BitstreamEntry getSubBlock(/*uint*/int ID) {
    BitstreamEntry E/*J*/= new BitstreamEntry();
    E.Kind = Unnamed_enum.SubBlock;
    E.ID = ID;
    return E;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamEntry::getRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 403,
   FQN="llvm::BitstreamEntry::getRecord", NM="_ZN4llvm14BitstreamEntry9getRecordEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitstreamReader.cpp -nm=_ZN4llvm14BitstreamEntry9getRecordEj")
  //</editor-fold>
  public static BitstreamEntry getRecord(/*uint*/int AbbrevID) {
    BitstreamEntry E/*J*/= new BitstreamEntry();
    E.Kind = Unnamed_enum.Record;
    E.ID = AbbrevID;
    return E;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamEntry::BitstreamEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 383,
   FQN="llvm::BitstreamEntry::BitstreamEntry", NM="_ZN4llvm14BitstreamEntryC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitstreamReader.cpp -nm=_ZN4llvm14BitstreamEntryC1Ev")
  //</editor-fold>
  public /*inline*/ BitstreamEntry() {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BitstreamEntry::BitstreamEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Bitcode/BitstreamReader.h", line = 383,
   FQN="llvm::BitstreamEntry::BitstreamEntry", NM="_ZN4llvm14BitstreamEntryC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitstreamReader.cpp -nm=_ZN4llvm14BitstreamEntryC1EOS0_")
  //</editor-fold>
  public /*inline*/ BitstreamEntry(JD$Move _dparam, final BitstreamEntry /*&&*/$Prm0) {
    // : Kind(static_cast<BitstreamEntry &&>().Kind), ID(static_cast<BitstreamEntry &&>().ID) 
    //START JInit
    this.Kind = $Prm0.Kind;
    this.ID = $Prm0.ID;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", ID=" + ID; // NOI18N
  }
}
