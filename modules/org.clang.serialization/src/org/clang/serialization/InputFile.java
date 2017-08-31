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

package org.clang.serialization;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.basic.*;
import org.clank.support.Native.NativePOD;
import org.llvm.adt.ADTAliases.PointerUInt2Pair;


/// \brief The input file that has been loaded from this AST file, along with
/// bools indicating whether this was an overridden buffer or if it was
/// out-of-date or not-found.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::InputFile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/Module.h", line = 57,
 FQN="clang::serialization::InputFile", NM="_ZN5clang13serialization9InputFileE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization9InputFileE")
//</editor-fold>
public class InputFile implements NativePOD<InputFile>, NativeMoveable<InputFile> {
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::InputFile::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/Module.h", line = 58,
   FQN="clang::serialization::InputFile::(anonymous)", NM="_ZN5clang13serialization9InputFileE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization9InputFileE_Unnamed_enum")
  //</editor-fold>
  private enum Unnamed_enum implements Native.NativeUIntEnum {
    Overridden(1),
    OutOfDate(2),
    NotFound(3);

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
  private PointerUInt2Pair</*const*/ FileEntry /*P*/ > Val;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::InputFile::InputFile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/Module.h", line = 66,
   FQN="clang::serialization::InputFile::InputFile", NM="_ZN5clang13serialization9InputFileC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization9InputFileC1Ev")
  //</editor-fold>
  public InputFile() {
    // : Val() 
    //START JInit
    this.Val = new PointerUInt2Pair</*const*/ FileEntry /*P*/ >();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::InputFile::InputFile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/Module.h", line = 67,
   FQN="clang::serialization::InputFile::InputFile", NM="_ZN5clang13serialization9InputFileC1EPKNS_9FileEntryEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization9InputFileC1EPKNS_9FileEntryEbb")
  //</editor-fold>
  public InputFile(/*const*/ FileEntry /*P*/ File) {
    this(File, 
      false, false);
  }
  public InputFile(/*const*/ FileEntry /*P*/ File, 
      boolean isOverridden/*= false*/) {
    this(File, 
      isOverridden, false);
  }
  public InputFile(/*const*/ FileEntry /*P*/ File, 
      boolean isOverridden/*= false*/, boolean isOutOfDate/*= false*/) {
    // : Val() 
    //START JInit
    this.Val = new PointerUInt2Pair</*const*/ FileEntry /*P*/ >();
    //END JInit
    assert (!(isOverridden && isOutOfDate)) : "an overridden cannot be out-of-date";
    /*uint*/int intVal = 0;
    if (isOverridden) {
      intVal = Unnamed_enum.Overridden.getValue();
    } else if (isOutOfDate) {
      intVal = Unnamed_enum.OutOfDate.getValue();
    }
    Val.setPointerAndInt(File, intVal);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::InputFile::getNotFound">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/Module.h", line = 79,
   FQN="clang::serialization::InputFile::getNotFound", NM="_ZN5clang13serialization9InputFile11getNotFoundEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization9InputFile11getNotFoundEv")
  //</editor-fold>
  public static InputFile getNotFound() {
    InputFile File/*J*/= new InputFile();
    File.Val.setInt(Unnamed_enum.NotFound.getValue());
    return File;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::InputFile::getFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/Module.h", line = 85,
   FQN="clang::serialization::InputFile::getFile", NM="_ZNK5clang13serialization9InputFile7getFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang13serialization9InputFile7getFileEv")
  //</editor-fold>
  public /*const*/ FileEntry /*P*/ getFile() /*const*/ {
    return Val.getPointer();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::InputFile::isOverridden">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/Module.h", line = 86,
   FQN="clang::serialization::InputFile::isOverridden", NM="_ZNK5clang13serialization9InputFile12isOverriddenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang13serialization9InputFile12isOverriddenEv")
  //</editor-fold>
  public boolean isOverridden() /*const*/ {
    return Val.getInt() == Unnamed_enum.Overridden.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::InputFile::isOutOfDate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/Module.h", line = 87,
   FQN="clang::serialization::InputFile::isOutOfDate", NM="_ZNK5clang13serialization9InputFile11isOutOfDateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang13serialization9InputFile11isOutOfDateEv")
  //</editor-fold>
  public boolean isOutOfDate() /*const*/ {
    return Val.getInt() == Unnamed_enum.OutOfDate.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::InputFile::isNotFound">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/Module.h", line = 88,
   FQN="clang::serialization::InputFile::isNotFound", NM="_ZNK5clang13serialization9InputFile10isNotFoundEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang13serialization9InputFile10isNotFoundEv")
  //</editor-fold>
  public boolean isNotFound() /*const*/ {
    return Val.getInt() == Unnamed_enum.NotFound.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::InputFile::InputFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/Module.h", line = 57,
   FQN="clang::serialization::InputFile::InputFile", NM="_ZN5clang13serialization9InputFileC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization9InputFileC1ERKS1_")
  //</editor-fold>
  public /*inline*/ InputFile(final /*const*/ InputFile /*&*/ $Prm0) {
    // : Val(.Val) 
    //START JInit
    this.Val = new PointerUInt2Pair</*const*/ FileEntry /*P*/ >($Prm0.Val);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::InputFile::InputFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/Module.h", line = 57,
   FQN="clang::serialization::InputFile::InputFile", NM="_ZN5clang13serialization9InputFileC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization9InputFileC1EOS1_")
  //</editor-fold>
  public /*inline*/ InputFile(JD$Move _dparam, final InputFile /*&&*/$Prm0) {
    // : Val(static_cast<InputFile &&>().Val) 
    //START JInit
    this.Val = new PointerUInt2Pair</*const*/ FileEntry /*P*/ >(JD$Move.INSTANCE, $Prm0.Val);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::InputFile::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/Module.h", line = 57,
   FQN="clang::serialization::InputFile::operator=", NM="_ZN5clang13serialization9InputFileaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization9InputFileaSERKS1_")
  //</editor-fold>
  public /*inline*/ InputFile /*&*/ $assign(final /*const*/ InputFile /*&*/ $Prm0) {
    this.Val.$assign($Prm0.Val);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::InputFile::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/Module.h", line = 57,
   FQN="clang::serialization::InputFile::operator=", NM="_ZN5clang13serialization9InputFileaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization9InputFileaSEOS1_")
  //</editor-fold>
  public /*inline*/ InputFile /*&*/ $assignMove(final InputFile /*&&*/$Prm0) {
    this.Val.$assignMove($Prm0.Val);
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override
  public InputFile clone() {
    return new InputFile(this);
  }

  @Override
  public InputFile move() {
    return new InputFile(JD$Move.INSTANCE, this);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Val=" + Val; // NOI18N
  }
}
