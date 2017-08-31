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
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;


// A helper class for defining ObjC TypeLocs that can qualified with
// protocols.
//
// TypeClass basically has to be either ObjCInterfaceType or
// ObjCObjectPointerType.
//<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeLoc">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 852,
 FQN="clang::ObjCObjectTypeLoc", NM="_ZN5clang17ObjCObjectTypeLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang17ObjCObjectTypeLocE")
//</editor-fold>
public class ObjCObjectTypeLoc<LocalData/*=ObjCObjectTypeLocInfo*/> extends /*public*/ Concrete$UnqualTypeLoc<ObjCObjectTypeLoc, ObjCObjectType, LocalData> {
  // TypeSourceInfo*'s are stored after Info, one for each type argument.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeLoc::getTypeArgLocArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 857,
   FQN="clang::ObjCObjectTypeLoc::getTypeArgLocArray", NM="_ZNK5clang17ObjCObjectTypeLoc18getTypeArgLocArrayEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang17ObjCObjectTypeLoc18getTypeArgLocArrayEv")
  //</editor-fold>
  private type$ptr<TypeSourceInfo /*P*/ /*P*/> getTypeArgLocArray() /*const*/ {
    return (type$ptr<TypeSourceInfo /*P*/ /*P*/>)this.getExtraLocalData();
  }

  
  // SourceLocations are stored after the type argument information, one for 
  // each Protocol.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeLoc::getProtocolLocArray">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 863,
   FQN="clang::ObjCObjectTypeLoc::getProtocolLocArray", NM="_ZNK5clang17ObjCObjectTypeLoc19getProtocolLocArrayEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang17ObjCObjectTypeLoc19getProtocolLocArrayEv")
  //</editor-fold>
  private type$ptr<SourceLocation> /*P*/ getProtocolLocArray() /*const*/ {
    return (type$ptr<SourceLocation> /*P*/ )((type$ptr)getTypeArgLocArray().$add(getNumTypeArgs()));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeLoc::getTypeArgsLAngleLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 868,
   FQN="clang::ObjCObjectTypeLoc::getTypeArgsLAngleLoc", NM="_ZNK5clang17ObjCObjectTypeLoc20getTypeArgsLAngleLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang17ObjCObjectTypeLoc20getTypeArgsLAngleLocEv")
  //</editor-fold>
  public SourceLocation getTypeArgsLAngleLoc() /*const*/ {
    return new SourceLocation(((ObjCObjectTypeLocInfo)this.<ObjCObjectTypeLocInfo>getLocalData()).TypeArgsLAngleLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeLoc::setTypeArgsLAngleLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 871,
   FQN="clang::ObjCObjectTypeLoc::setTypeArgsLAngleLoc", NM="_ZN5clang17ObjCObjectTypeLoc20setTypeArgsLAngleLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang17ObjCObjectTypeLoc20setTypeArgsLAngleLocENS_14SourceLocationE")
  //</editor-fold>
  public void setTypeArgsLAngleLoc(SourceLocation Loc) {
    ((ObjCObjectTypeLocInfo)this.<ObjCObjectTypeLocInfo>getLocalData()).TypeArgsLAngleLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeLoc::getTypeArgsRAngleLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 875,
   FQN="clang::ObjCObjectTypeLoc::getTypeArgsRAngleLoc", NM="_ZNK5clang17ObjCObjectTypeLoc20getTypeArgsRAngleLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang17ObjCObjectTypeLoc20getTypeArgsRAngleLocEv")
  //</editor-fold>
  public SourceLocation getTypeArgsRAngleLoc() /*const*/ {
    return new SourceLocation(((ObjCObjectTypeLocInfo)this.<ObjCObjectTypeLocInfo>getLocalData()).TypeArgsRAngleLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeLoc::setTypeArgsRAngleLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 878,
   FQN="clang::ObjCObjectTypeLoc::setTypeArgsRAngleLoc", NM="_ZN5clang17ObjCObjectTypeLoc20setTypeArgsRAngleLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang17ObjCObjectTypeLoc20setTypeArgsRAngleLocENS_14SourceLocationE")
  //</editor-fold>
  public void setTypeArgsRAngleLoc(SourceLocation Loc) {
    ((ObjCObjectTypeLocInfo)this.<ObjCObjectTypeLocInfo>getLocalData()).TypeArgsRAngleLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeLoc::getNumTypeArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 882,
   FQN="clang::ObjCObjectTypeLoc::getNumTypeArgs", NM="_ZNK5clang17ObjCObjectTypeLoc14getNumTypeArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang17ObjCObjectTypeLoc14getNumTypeArgsEv")
  //</editor-fold>
  public /*uint*/int getNumTypeArgs() /*const*/ {
    return this.getTypePtr().getTypeArgsAsWritten().size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeLoc::getTypeArgTInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 886,
   FQN="clang::ObjCObjectTypeLoc::getTypeArgTInfo", NM="_ZNK5clang17ObjCObjectTypeLoc15getTypeArgTInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang17ObjCObjectTypeLoc15getTypeArgTInfoEj")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getTypeArgTInfo(/*uint*/int i) /*const*/ {
    assert ($less_uint(i, getNumTypeArgs())) : "Index is out of bounds!";
    return getTypeArgLocArray().$at(i);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeLoc::setTypeArgTInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 891,
   FQN="clang::ObjCObjectTypeLoc::setTypeArgTInfo", NM="_ZN5clang17ObjCObjectTypeLoc15setTypeArgTInfoEjPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang17ObjCObjectTypeLoc15setTypeArgTInfoEjPNS_14TypeSourceInfoE")
  //</editor-fold>
  public void setTypeArgTInfo(/*uint*/int i, TypeSourceInfo /*P*/ TInfo) {
    assert ($less_uint(i, getNumTypeArgs())) : "Index is out of bounds!";
    getTypeArgLocArray().$set(i, TInfo);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeLoc::getProtocolLAngleLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 896,
   FQN="clang::ObjCObjectTypeLoc::getProtocolLAngleLoc", NM="_ZNK5clang17ObjCObjectTypeLoc20getProtocolLAngleLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang17ObjCObjectTypeLoc20getProtocolLAngleLocEv")
  //</editor-fold>
  public SourceLocation getProtocolLAngleLoc() /*const*/ {
    return new SourceLocation(((ObjCObjectTypeLocInfo)this.<ObjCObjectTypeLocInfo>getLocalData()).ProtocolLAngleLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeLoc::setProtocolLAngleLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 899,
   FQN="clang::ObjCObjectTypeLoc::setProtocolLAngleLoc", NM="_ZN5clang17ObjCObjectTypeLoc20setProtocolLAngleLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang17ObjCObjectTypeLoc20setProtocolLAngleLocENS_14SourceLocationE")
  //</editor-fold>
  public void setProtocolLAngleLoc(SourceLocation Loc) {
    ((ObjCObjectTypeLocInfo)this.<ObjCObjectTypeLocInfo>getLocalData()).ProtocolLAngleLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeLoc::getProtocolRAngleLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 903,
   FQN="clang::ObjCObjectTypeLoc::getProtocolRAngleLoc", NM="_ZNK5clang17ObjCObjectTypeLoc20getProtocolRAngleLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang17ObjCObjectTypeLoc20getProtocolRAngleLocEv")
  //</editor-fold>
  public SourceLocation getProtocolRAngleLoc() /*const*/ {
    return new SourceLocation(((ObjCObjectTypeLocInfo)this.<ObjCObjectTypeLocInfo>getLocalData()).ProtocolRAngleLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeLoc::setProtocolRAngleLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 906,
   FQN="clang::ObjCObjectTypeLoc::setProtocolRAngleLoc", NM="_ZN5clang17ObjCObjectTypeLoc20setProtocolRAngleLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang17ObjCObjectTypeLoc20setProtocolRAngleLocENS_14SourceLocationE")
  //</editor-fold>
  public void setProtocolRAngleLoc(SourceLocation Loc) {
    ((ObjCObjectTypeLocInfo)this.<ObjCObjectTypeLocInfo>getLocalData()).ProtocolRAngleLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeLoc::getNumProtocols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 910,
   FQN="clang::ObjCObjectTypeLoc::getNumProtocols", NM="_ZNK5clang17ObjCObjectTypeLoc15getNumProtocolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang17ObjCObjectTypeLoc15getNumProtocolsEv")
  //</editor-fold>
  public /*uint*/int getNumProtocols() /*const*/ {
    return this.getTypePtr().getNumProtocols();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeLoc::getProtocolLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 914,
   FQN="clang::ObjCObjectTypeLoc::getProtocolLoc", NM="_ZNK5clang17ObjCObjectTypeLoc14getProtocolLocEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang17ObjCObjectTypeLoc14getProtocolLocEj")
  //</editor-fold>
  public SourceLocation getProtocolLoc(/*uint*/int i) /*const*/ {
    assert ($less_uint(i, getNumProtocols())) : "Index is out of bounds!";
    return new SourceLocation(getProtocolLocArray().$at(i));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeLoc::setProtocolLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 918,
   FQN="clang::ObjCObjectTypeLoc::setProtocolLoc", NM="_ZN5clang17ObjCObjectTypeLoc14setProtocolLocEjNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang17ObjCObjectTypeLoc14setProtocolLocEjNS_14SourceLocationE")
  //</editor-fold>
  public void setProtocolLoc(/*uint*/int i, SourceLocation Loc) {
    assert ($less_uint(i, getNumProtocols())) : "Index is out of bounds!";
    getProtocolLocArray().$at(i).$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeLoc::getProtocol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 923,
   FQN="clang::ObjCObjectTypeLoc::getProtocol", NM="_ZNK5clang17ObjCObjectTypeLoc11getProtocolEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang17ObjCObjectTypeLoc11getProtocolEj")
  //</editor-fold>
  public ObjCProtocolDecl /*P*/ getProtocol(/*uint*/int i) /*const*/ {
    assert ($less_uint(i, getNumProtocols())) : "Index is out of bounds!";
    return (this.getTypePtr().qual_begin().$add(i)).$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeLoc::getProtocolLocs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 929,
   FQN="clang::ObjCObjectTypeLoc::getProtocolLocs", NM="_ZNK5clang17ObjCObjectTypeLoc15getProtocolLocsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang17ObjCObjectTypeLoc15getProtocolLocsEv")
  //</editor-fold>
  public ArrayRef<SourceLocation> getProtocolLocs() /*const*/ {
    return llvm.makeArrayRef(getProtocolLocArray(), getNumProtocols());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeLoc::hasBaseTypeAsWritten">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 933,
   FQN="clang::ObjCObjectTypeLoc::hasBaseTypeAsWritten", NM="_ZNK5clang17ObjCObjectTypeLoc20hasBaseTypeAsWrittenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang17ObjCObjectTypeLoc20hasBaseTypeAsWrittenEv")
  //</editor-fold>
  public boolean hasBaseTypeAsWritten() /*const*/ {
    return ((ObjCObjectTypeLocInfo)this.<ObjCObjectTypeLocInfo>getLocalData()).HasBaseTypeAsWritten;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeLoc::setHasBaseTypeAsWritten">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 937,
   FQN="clang::ObjCObjectTypeLoc::setHasBaseTypeAsWritten", NM="_ZN5clang17ObjCObjectTypeLoc23setHasBaseTypeAsWrittenEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang17ObjCObjectTypeLoc23setHasBaseTypeAsWrittenEb")
  //</editor-fold>
  public void setHasBaseTypeAsWritten(boolean HasBaseType) {
    ((ObjCObjectTypeLocInfo)this.<ObjCObjectTypeLocInfo>getLocalData()).HasBaseTypeAsWritten = HasBaseType;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeLoc::getBaseLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 941,
   FQN="clang::ObjCObjectTypeLoc::getBaseLoc", NM="_ZNK5clang17ObjCObjectTypeLoc10getBaseLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang17ObjCObjectTypeLoc10getBaseLocEv")
  //</editor-fold>
  public TypeLoc getBaseLoc() /*const*/ {
    return getInnerTypeLoc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeLoc::getLocalSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 945,
   FQN="clang::ObjCObjectTypeLoc::getLocalSourceRange", NM="_ZNK5clang17ObjCObjectTypeLoc19getLocalSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang17ObjCObjectTypeLoc19getLocalSourceRangeEv")
  //</editor-fold>
  public SourceRange getLocalSourceRange() /*const*/ {
    SourceLocation start = getTypeArgsLAngleLoc();
    if (start.isInvalid()) {
      start.$assignMove(getProtocolLAngleLoc());
    }
    SourceLocation end = getProtocolRAngleLoc();
    if (end.isInvalid()) {
      end.$assignMove(getTypeArgsRAngleLoc());
    }
    return new SourceRange(/*NO_COPY*/start, /*NO_COPY*/end);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeLoc::initializeLocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp", line = 392,
   FQN="clang::ObjCObjectTypeLoc::initializeLocal", NM="_ZN5clang17ObjCObjectTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang17ObjCObjectTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE")
  //</editor-fold>
  public void initializeLocal(final ASTContext /*&*/ Context, 
                 SourceLocation Loc) {
    setHasBaseTypeAsWritten(true);
    setTypeArgsLAngleLoc(/*NO_COPY*/Loc);
    setTypeArgsRAngleLoc(/*NO_COPY*/Loc);
    for (/*uint*/int i = 0, e = getNumTypeArgs(); i != e; ++i) {
      setTypeArgTInfo(i, 
          Context.getTrivialTypeSourceInfo(new QualType(getTypePtr().getTypeArgsAsWritten().$at(i)), new SourceLocation(Loc)));
    }
    setProtocolLAngleLoc(/*NO_COPY*/Loc);
    setProtocolRAngleLoc(/*NO_COPY*/Loc);
    for (/*uint*/int i = 0, e = getNumProtocols(); i != e; ++i)  {
      setProtocolLoc(i, /*NO_COPY*/Loc);
    }
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeLoc::getExtraLocalDataSize">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 957,
   FQN="clang::ObjCObjectTypeLoc::getExtraLocalDataSize", NM="_ZNK5clang17ObjCObjectTypeLoc21getExtraLocalDataSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang17ObjCObjectTypeLoc21getExtraLocalDataSizeEv")
  //</editor-fold>
  public /*uint*/int getExtraLocalDataSize() /*const*/ {
    return this.getNumTypeArgs() * $sizeof_ptr_TypeSourceInfo(/*TypeSourceInfo  */)
       + this.getNumProtocols() * $sizeof_SourceLocation();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeLoc::getExtraLocalDataAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 962,
   FQN="clang::ObjCObjectTypeLoc::getExtraLocalDataAlignment", NM="_ZNK5clang17ObjCObjectTypeLoc26getExtraLocalDataAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang17ObjCObjectTypeLoc26getExtraLocalDataAlignmentEv")
  //</editor-fold>
  public /*uint*/int getExtraLocalDataAlignment() /*const*/ {
    assert ($greatereq_uint(alignOf(ObjCObjectTypeLoc.class), alignOf(TypeSourceInfo.class))) : "not enough alignment for tail-allocated data";
    return alignOf(TypeSourceInfo.class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeLoc::getInnerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 969,
   FQN="clang::ObjCObjectTypeLoc::getInnerType", NM="_ZNK5clang17ObjCObjectTypeLoc12getInnerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang17ObjCObjectTypeLoc12getInnerTypeEv")
  //</editor-fold>
  public QualType getInnerType() /*const*/ {
    return getTypePtr().getBaseType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeLoc::ObjCObjectTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 852,
   FQN="clang::ObjCObjectTypeLoc::ObjCObjectTypeLoc", NM="_ZN5clang17ObjCObjectTypeLocC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang17ObjCObjectTypeLocC1Ev")
  //</editor-fold>
  public /*inline*/ ObjCObjectTypeLoc() {
    // : ConcreteTypeLoc<UnqualTypeLoc, ObjCObjectTypeLoc, ObjCObjectType, ObjCObjectTypeLocInfo>() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeLoc::ObjCObjectTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 852,
   FQN="clang::ObjCObjectTypeLoc::ObjCObjectTypeLoc", NM="_ZN5clang17ObjCObjectTypeLocC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang17ObjCObjectTypeLocC1ERKS0_")
  //</editor-fold>
  public /*inline*/ ObjCObjectTypeLoc(final /*const*/ ObjCObjectTypeLoc /*&*/ $Prm0) {
    // : ConcreteTypeLoc<UnqualTypeLoc, ObjCObjectTypeLoc, ObjCObjectType, ObjCObjectTypeLocInfo>() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectTypeLoc::ObjCObjectTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 852,
   FQN="clang::ObjCObjectTypeLoc::ObjCObjectTypeLoc", NM="_ZN5clang17ObjCObjectTypeLocC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang17ObjCObjectTypeLocC1EOS0_")
  //</editor-fold>
  public /*inline*/ ObjCObjectTypeLoc(JD$Move _dparam, final ObjCObjectTypeLoc /*&&*/$Prm0) {
    // : ConcreteTypeLoc<UnqualTypeLoc, ObjCObjectTypeLoc, ObjCObjectType, ObjCObjectTypeLocInfo>(static_cast<ObjCObjectTypeLoc &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  protected static int $sizeof_SourceLocation() {
    return 1;
  }

  protected static int $sizeof_ptr_TypeSourceInfo() {
    return 1;
  }

  @Override
  protected LocalData createJavaEmptyLocalTypeLocInfo() {
    return (LocalData) new ObjCObjectTypeLocInfo();
  }

  @Override
  protected Class<? extends ObjCObjectType> getTypeClass() {
    return ObjCObjectType.class;
  }


  @Override protected final void initJavaExtraLocalData(type$ptr extraLocalData$Ptr, int NumExtra) {
    assert NumExtra == (this.getNumTypeArgs() + this.getNumProtocols()) : "expect request for extra data for TypeSourceInfo pointers and SourceLocations";
    if (NativeTrace.isDebugMode()) {
      // as extra data we keep TemplateArgumentLocInfo pointers, check that array size is enough and contains nulls
      for (int idx = 0; idx < this.getNumTypeArgs(); idx++) {
        assert extraLocalData$Ptr.$at(idx) == null : "must be not occupied placeholder for TemplateArgumentLocInfo *";
      }
    }
    // must have non-null values
    for (int idx = this.getNumTypeArgs(); idx < NumExtra; idx++) {
      assert extraLocalData$Ptr.$at(idx) == null : "must be not occupied placeholder for SourceLocation";
      extraLocalData$Ptr.$set(idx, new SourceLocation());
    }
  }

  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
