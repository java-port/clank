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
import static org.clank.support.Unsigned.*;


/// \brief Instances of this class represent the information from a
/// .cv_loc directive.
//<editor-fold defaultstate="collapsed" desc="llvm::MCCVLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeView.h", line = 31,
 FQN="llvm::MCCVLoc", NM="_ZN4llvm7MCCVLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm7MCCVLocE")
//</editor-fold>
public class MCCVLoc {
  private /*uint32_t*/int FunctionId;
  private /*uint32_t*/int FileNum;
  private /*uint32_t*/int Line;
  private /*uint16_t*/char Column;
  private /*JBIT uint16_t*/ boolean PrologueEnd /*: 1*/;
  private /*JBIT uint16_t*/ boolean IsStmt /*: 1*/;
/*private:*/
  // MCContext manages these
  /*friend  class MCContext*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCVLoc::MCCVLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeView.h", line = 41,
   FQN="llvm::MCCVLoc::MCCVLoc", NM="_ZN4llvm7MCCVLocC1Ejjjjbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm7MCCVLocC1Ejjjjbb")
  //</editor-fold>
  private MCCVLoc(/*uint*/int functionid, /*uint*/int fileNum, /*uint*/int line, /*uint*/int column, 
      boolean prologueend, boolean isstmt) {
    // : FunctionId(functionid), FileNum(fileNum), Line(line), Column(column), PrologueEnd(prologueend), IsStmt(isstmt) 
    //START JInit
    this.FunctionId = functionid;
    this.FileNum = fileNum;
    this.Line = line;
    this.Column = $uint2ushort(column);
    this.PrologueEnd = prologueend;
    this.IsStmt = isstmt;
    //END JInit
  }


  // Allow the default copy constructor and assignment operator to be used
  // for an MCCVLoc object.
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCVLoc::getFunctionId">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeView.h", line = 50,
   FQN="llvm::MCCVLoc::getFunctionId", NM="_ZNK4llvm7MCCVLoc13getFunctionIdEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm7MCCVLoc13getFunctionIdEv")
  //</editor-fold>
  public /*uint*/int getFunctionId() /*const*/ {
    return FunctionId;
  }

  
  /// \brief Get the FileNum of this MCCVLoc.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCVLoc::getFileNum">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeView.h", line = 53,
   FQN="llvm::MCCVLoc::getFileNum", NM="_ZNK4llvm7MCCVLoc10getFileNumEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm7MCCVLoc10getFileNumEv")
  //</editor-fold>
  public /*uint*/int getFileNum() /*const*/ {
    return FileNum;
  }

  
  /// \brief Get the Line of this MCCVLoc.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCVLoc::getLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeView.h", line = 56,
   FQN="llvm::MCCVLoc::getLine", NM="_ZNK4llvm7MCCVLoc7getLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm7MCCVLoc7getLineEv")
  //</editor-fold>
  public /*uint*/int getLine() /*const*/ {
    return Line;
  }

  
  /// \brief Get the Column of this MCCVLoc.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCVLoc::getColumn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeView.h", line = 59,
   FQN="llvm::MCCVLoc::getColumn", NM="_ZNK4llvm7MCCVLoc9getColumnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm7MCCVLoc9getColumnEv")
  //</editor-fold>
  public /*uint*/int getColumn() /*const*/ {
    return $ushort2uint(Column);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCVLoc::isPrologueEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeView.h", line = 61,
   FQN="llvm::MCCVLoc::isPrologueEnd", NM="_ZNK4llvm7MCCVLoc13isPrologueEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm7MCCVLoc13isPrologueEndEv")
  //</editor-fold>
  public boolean isPrologueEnd() /*const*/ {
    return PrologueEnd;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCCVLoc::isStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeView.h", line = 62,
   FQN="llvm::MCCVLoc::isStmt", NM="_ZNK4llvm7MCCVLoc6isStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm7MCCVLoc6isStmtEv")
  //</editor-fold>
  public boolean isStmt() /*const*/ {
    return IsStmt;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCVLoc::setFunctionId">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeView.h", line = 64,
   FQN="llvm::MCCVLoc::setFunctionId", NM="_ZN4llvm7MCCVLoc13setFunctionIdEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm7MCCVLoc13setFunctionIdEj")
  //</editor-fold>
  public void setFunctionId(/*uint*/int FID) {
    FunctionId = FID;
  }

  
  /// \brief Set the FileNum of this MCCVLoc.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCVLoc::setFileNum">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeView.h", line = 67,
   FQN="llvm::MCCVLoc::setFileNum", NM="_ZN4llvm7MCCVLoc10setFileNumEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm7MCCVLoc10setFileNumEj")
  //</editor-fold>
  public void setFileNum(/*uint*/int fileNum) {
    FileNum = fileNum;
  }

  
  /// \brief Set the Line of this MCCVLoc.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCVLoc::setLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeView.h", line = 70,
   FQN="llvm::MCCVLoc::setLine", NM="_ZN4llvm7MCCVLoc7setLineEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm7MCCVLoc7setLineEj")
  //</editor-fold>
  public void setLine(/*uint*/int line) {
    Line = line;
  }

  
  /// \brief Set the Column of this MCCVLoc.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCVLoc::setColumn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeView.h", line = 73,
   FQN="llvm::MCCVLoc::setColumn", NM="_ZN4llvm7MCCVLoc9setColumnEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm7MCCVLoc9setColumnEj")
  //</editor-fold>
  public void setColumn(/*uint*/int column) {
    assert ($lesseq_uint(column, (65535/*U*/)));
    Column = $uint2ushort(column);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCVLoc::setPrologueEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeView.h", line = 78,
   FQN="llvm::MCCVLoc::setPrologueEnd", NM="_ZN4llvm7MCCVLoc14setPrologueEndEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm7MCCVLoc14setPrologueEndEb")
  //</editor-fold>
  public void setPrologueEnd(boolean PE) {
    PrologueEnd = PE;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCCVLoc::setIsStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeView.h", line = 79,
   FQN="llvm::MCCVLoc::setIsStmt", NM="_ZN4llvm7MCCVLoc9setIsStmtEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm7MCCVLoc9setIsStmtEb")
  //</editor-fold>
  public void setIsStmt(boolean IS) {
    IsStmt = IS;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCCVLoc::MCCVLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeView.h", line = 31,
   FQN="llvm::MCCVLoc::MCCVLoc", NM="_ZN4llvm7MCCVLocC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm7MCCVLocC1ERKS0_")
  //</editor-fold>
  public /*inline*/ MCCVLoc(final /*const*/ MCCVLoc /*&*/ $Prm0) {
    // : FunctionId(.FunctionId), FileNum(.FileNum), Line(.Line), Column(.Column), PrologueEnd(.PrologueEnd), IsStmt(.IsStmt) 
    //START JInit
    this.FunctionId = $Prm0.FunctionId;
    this.FileNum = $Prm0.FileNum;
    this.Line = $Prm0.Line;
    this.Column = $Prm0.Column;
    this.PrologueEnd = $Prm0.PrologueEnd;
    this.IsStmt = $Prm0.IsStmt;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCCVLoc::MCCVLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeView.h", line = 31,
   FQN="llvm::MCCVLoc::MCCVLoc", NM="_ZN4llvm7MCCVLocC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm7MCCVLocC1EOS0_")
  //</editor-fold>
  public /*inline*/ MCCVLoc(JD$Move _dparam, final MCCVLoc /*&&*/$Prm0) {
    // : FunctionId(static_cast<MCCVLoc &&>().FunctionId), FileNum(static_cast<MCCVLoc &&>().FileNum), Line(static_cast<MCCVLoc &&>().Line), Column(static_cast<MCCVLoc &&>().Column), PrologueEnd(static_cast<MCCVLoc &&>().PrologueEnd), IsStmt(static_cast<MCCVLoc &&>().IsStmt) 
    //START JInit
    this.FunctionId = $Prm0.FunctionId;
    this.FileNum = $Prm0.FileNum;
    this.Line = $Prm0.Line;
    this.Column = $Prm0.Column;
    this.PrologueEnd = $Prm0.PrologueEnd;
    this.IsStmt = $Prm0.IsStmt;
    //END JInit
  }

  public MCCVLoc() {
  }

  public MCCVLoc(int FunctionId, int FileNum, int Line, char Column, boolean PrologueEnd, boolean IsStmt) {
    this.FunctionId = FunctionId;
    this.FileNum = FileNum;
    this.Line = Line;
    this.Column = Column;
    this.PrologueEnd = PrologueEnd;
    this.IsStmt = IsStmt;
  }

  
  @Override public String toString() {
    return "" + "FunctionId=" + FunctionId // NOI18N
              + ", FileNum=" + FileNum // NOI18N
              + ", Line=" + Line // NOI18N
              + ", Column=" + $ushort2uint(Column) // NOI18N
              + ", PrologueEnd=" + PrologueEnd // NOI18N
              + ", IsStmt=" + IsStmt; // NOI18N
  }
}
