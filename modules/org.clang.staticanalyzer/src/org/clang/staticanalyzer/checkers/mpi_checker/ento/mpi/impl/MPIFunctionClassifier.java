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

package org.clang.staticanalyzer.checkers.mpi_checker.ento.mpi.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIFunctionClassifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.h", line = 24,
 FQN="clang::ento::mpi::MPIFunctionClassifier", NM="_ZN5clang4ento3mpi21MPIFunctionClassifierE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIBugReporter.cpp -nm=_ZN5clang4ento3mpi21MPIFunctionClassifierE")
//</editor-fold>
public class MPIFunctionClassifier implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIFunctionClassifier::MPIFunctionClassifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.h", line = 26,
   FQN="clang::ento::mpi::MPIFunctionClassifier::MPIFunctionClassifier", NM="_ZN5clang4ento3mpi21MPIFunctionClassifierC1ERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIBugReporter.cpp -nm=_ZN5clang4ento3mpi21MPIFunctionClassifierC1ERNS_10ASTContextE")
  //</editor-fold>
  public MPIFunctionClassifier(final ASTContext /*&*/ ASTCtx) {
    // : MPINonBlockingTypes(), MPIPointToPointTypes(), MPICollectiveTypes(), MPIPointToCollTypes(), MPICollToPointTypes(), MPICollToCollTypes(), MPIType(), IdentInfo_MPI_Send(null), IdentInfo_MPI_Isend(null), IdentInfo_MPI_Ssend(null), IdentInfo_MPI_Issend(null), IdentInfo_MPI_Bsend(null), IdentInfo_MPI_Ibsend(null), IdentInfo_MPI_Rsend(null), IdentInfo_MPI_Irsend(null), IdentInfo_MPI_Recv(null), IdentInfo_MPI_Irecv(null), IdentInfo_MPI_Scatter(null), IdentInfo_MPI_Iscatter(null), IdentInfo_MPI_Gather(null), IdentInfo_MPI_Igather(null), IdentInfo_MPI_Allgather(null), IdentInfo_MPI_Iallgather(null), IdentInfo_MPI_Bcast(null), IdentInfo_MPI_Ibcast(null), IdentInfo_MPI_Reduce(null), IdentInfo_MPI_Ireduce(null), IdentInfo_MPI_Allreduce(null), IdentInfo_MPI_Iallreduce(null), IdentInfo_MPI_Alltoall(null), IdentInfo_MPI_Ialltoall(null), IdentInfo_MPI_Barrier(null), IdentInfo_MPI_Comm_rank(null), IdentInfo_MPI_Comm_size(null), IdentInfo_MPI_Wait(null), IdentInfo_MPI_Waitall(null) 
    //START JInit
    this.MPINonBlockingTypes = new SmallVector<IdentifierInfo /*P*/>(12, (IdentifierInfo /*P*/)null);
    this.MPIPointToPointTypes = new SmallVector<IdentifierInfo /*P*/>(10, (IdentifierInfo /*P*/)null);
    this.MPICollectiveTypes = new SmallVector<IdentifierInfo /*P*/>(16, (IdentifierInfo /*P*/)null);
    this.MPIPointToCollTypes = new SmallVector<IdentifierInfo /*P*/>(4, (IdentifierInfo /*P*/)null);
    this.MPICollToPointTypes = new SmallVector<IdentifierInfo /*P*/>(4, (IdentifierInfo /*P*/)null);
    this.MPICollToCollTypes = new SmallVector<IdentifierInfo /*P*/>(6, (IdentifierInfo /*P*/)null);
    this.MPIType = new SmallVector<IdentifierInfo /*P*/>(32, (IdentifierInfo /*P*/)null);
    /*InClass*/this.IdentInfo_MPI_Send = null;
    /*InClass*/this.IdentInfo_MPI_Isend = null;
    /*InClass*/this.IdentInfo_MPI_Ssend = null;
    /*InClass*/this.IdentInfo_MPI_Issend = null;
    /*InClass*/this.IdentInfo_MPI_Bsend = null;
    /*InClass*/this.IdentInfo_MPI_Ibsend = null;
    /*InClass*/this.IdentInfo_MPI_Rsend = null;
    /*InClass*/this.IdentInfo_MPI_Irsend = null;
    /*InClass*/this.IdentInfo_MPI_Recv = null;
    /*InClass*/this.IdentInfo_MPI_Irecv = null;
    /*InClass*/this.IdentInfo_MPI_Scatter = null;
    /*InClass*/this.IdentInfo_MPI_Iscatter = null;
    /*InClass*/this.IdentInfo_MPI_Gather = null;
    /*InClass*/this.IdentInfo_MPI_Igather = null;
    /*InClass*/this.IdentInfo_MPI_Allgather = null;
    /*InClass*/this.IdentInfo_MPI_Iallgather = null;
    /*InClass*/this.IdentInfo_MPI_Bcast = null;
    /*InClass*/this.IdentInfo_MPI_Ibcast = null;
    /*InClass*/this.IdentInfo_MPI_Reduce = null;
    /*InClass*/this.IdentInfo_MPI_Ireduce = null;
    /*InClass*/this.IdentInfo_MPI_Allreduce = null;
    /*InClass*/this.IdentInfo_MPI_Iallreduce = null;
    /*InClass*/this.IdentInfo_MPI_Alltoall = null;
    /*InClass*/this.IdentInfo_MPI_Ialltoall = null;
    /*InClass*/this.IdentInfo_MPI_Barrier = null;
    /*InClass*/this.IdentInfo_MPI_Comm_rank = null;
    /*InClass*/this.IdentInfo_MPI_Comm_size = null;
    /*InClass*/this.IdentInfo_MPI_Wait = null;
    /*InClass*/this.IdentInfo_MPI_Waitall = null;
    //END JInit
    identifierInit(ASTCtx);
  }

  
  // general identifiers
  
  // general identifiers
  
  // general identifiers
  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIFunctionClassifier::isMPIType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp", line = 204,
   FQN="clang::ento::mpi::MPIFunctionClassifier::isMPIType", NM="_ZNK5clang4ento3mpi21MPIFunctionClassifier9isMPITypeEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp -nm=_ZNK5clang4ento3mpi21MPIFunctionClassifier9isMPITypeEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public boolean isMPIType(/*const*/ IdentifierInfo /*P*/ IdentInfo) /*const*/ {
    return AdtsupportLlvmGlobals.is_contained(MPIType, IdentInfo);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIFunctionClassifier::isNonBlockingType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp", line = 208,
   FQN="clang::ento::mpi::MPIFunctionClassifier::isNonBlockingType", NM="_ZNK5clang4ento3mpi21MPIFunctionClassifier17isNonBlockingTypeEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp -nm=_ZNK5clang4ento3mpi21MPIFunctionClassifier17isNonBlockingTypeEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public boolean isNonBlockingType(/*const*/ IdentifierInfo /*P*/ IdentInfo) /*const*/ {
    return AdtsupportLlvmGlobals.is_contained(MPINonBlockingTypes, IdentInfo);
  }


  
  // point-to-point identifiers
  
  // point-to-point identifiers
  
  // point-to-point identifiers
  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIFunctionClassifier::isPointToPointType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp", line = 214,
   FQN="clang::ento::mpi::MPIFunctionClassifier::isPointToPointType", NM="_ZNK5clang4ento3mpi21MPIFunctionClassifier18isPointToPointTypeEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp -nm=_ZNK5clang4ento3mpi21MPIFunctionClassifier18isPointToPointTypeEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public boolean isPointToPointType(/*const*/ IdentifierInfo /*P*/ IdentInfo) /*const*/ {
    return AdtsupportLlvmGlobals.is_contained(MPIPointToPointTypes, IdentInfo);
  }


  
  // collective identifiers
  
  // collective identifiers
  
  // collective identifiers
  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIFunctionClassifier::isCollectiveType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp", line = 220,
   FQN="clang::ento::mpi::MPIFunctionClassifier::isCollectiveType", NM="_ZNK5clang4ento3mpi21MPIFunctionClassifier16isCollectiveTypeEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp -nm=_ZNK5clang4ento3mpi21MPIFunctionClassifier16isCollectiveTypeEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public boolean isCollectiveType(/*const*/ IdentifierInfo /*P*/ IdentInfo) /*const*/ {
    return AdtsupportLlvmGlobals.is_contained(MPICollectiveTypes, IdentInfo);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIFunctionClassifier::isCollToColl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp", line = 225,
   FQN="clang::ento::mpi::MPIFunctionClassifier::isCollToColl", NM="_ZNK5clang4ento3mpi21MPIFunctionClassifier12isCollToCollEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp -nm=_ZNK5clang4ento3mpi21MPIFunctionClassifier12isCollToCollEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public boolean isCollToColl(/*const*/ IdentifierInfo /*P*/ IdentInfo) /*const*/ {
    return AdtsupportLlvmGlobals.is_contained(MPICollToCollTypes, IdentInfo);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIFunctionClassifier::isScatterType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp", line = 230,
   FQN="clang::ento::mpi::MPIFunctionClassifier::isScatterType", NM="_ZNK5clang4ento3mpi21MPIFunctionClassifier13isScatterTypeEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp -nm=_ZNK5clang4ento3mpi21MPIFunctionClassifier13isScatterTypeEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public boolean isScatterType(/*const*/ IdentifierInfo /*P*/ IdentInfo) /*const*/ {
    return IdentInfo == IdentInfo_MPI_Scatter
       || IdentInfo == IdentInfo_MPI_Iscatter;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIFunctionClassifier::isGatherType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp", line = 236,
   FQN="clang::ento::mpi::MPIFunctionClassifier::isGatherType", NM="_ZNK5clang4ento3mpi21MPIFunctionClassifier12isGatherTypeEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp -nm=_ZNK5clang4ento3mpi21MPIFunctionClassifier12isGatherTypeEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public boolean isGatherType(/*const*/ IdentifierInfo /*P*/ IdentInfo) /*const*/ {
    return IdentInfo == IdentInfo_MPI_Gather
       || IdentInfo == IdentInfo_MPI_Igather
       || IdentInfo == IdentInfo_MPI_Allgather
       || IdentInfo == IdentInfo_MPI_Iallgather;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIFunctionClassifier::isAllgatherType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp", line = 244,
   FQN="clang::ento::mpi::MPIFunctionClassifier::isAllgatherType", NM="_ZNK5clang4ento3mpi21MPIFunctionClassifier15isAllgatherTypeEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp -nm=_ZNK5clang4ento3mpi21MPIFunctionClassifier15isAllgatherTypeEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public boolean isAllgatherType(/*const*/ IdentifierInfo /*P*/ IdentInfo) /*const*/ {
    return IdentInfo == IdentInfo_MPI_Allgather
       || IdentInfo == IdentInfo_MPI_Iallgather;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIFunctionClassifier::isAlltoallType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp", line = 250,
   FQN="clang::ento::mpi::MPIFunctionClassifier::isAlltoallType", NM="_ZNK5clang4ento3mpi21MPIFunctionClassifier14isAlltoallTypeEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp -nm=_ZNK5clang4ento3mpi21MPIFunctionClassifier14isAlltoallTypeEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public boolean isAlltoallType(/*const*/ IdentifierInfo /*P*/ IdentInfo) /*const*/ {
    return IdentInfo == IdentInfo_MPI_Alltoall
       || IdentInfo == IdentInfo_MPI_Ialltoall;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIFunctionClassifier::isReduceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp", line = 260,
   FQN="clang::ento::mpi::MPIFunctionClassifier::isReduceType", NM="_ZNK5clang4ento3mpi21MPIFunctionClassifier12isReduceTypeEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp -nm=_ZNK5clang4ento3mpi21MPIFunctionClassifier12isReduceTypeEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public boolean isReduceType(/*const*/ IdentifierInfo /*P*/ IdentInfo) /*const*/ {
    return IdentInfo == IdentInfo_MPI_Reduce
       || IdentInfo == IdentInfo_MPI_Ireduce
       || IdentInfo == IdentInfo_MPI_Allreduce
       || IdentInfo == IdentInfo_MPI_Iallreduce;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIFunctionClassifier::isBcastType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp", line = 256,
   FQN="clang::ento::mpi::MPIFunctionClassifier::isBcastType", NM="_ZNK5clang4ento3mpi21MPIFunctionClassifier11isBcastTypeEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp -nm=_ZNK5clang4ento3mpi21MPIFunctionClassifier11isBcastTypeEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public boolean isBcastType(/*const*/ IdentifierInfo /*P*/ IdentInfo) /*const*/ {
    return IdentInfo == IdentInfo_MPI_Bcast || IdentInfo == IdentInfo_MPI_Ibcast;
  }


  
  // additional identifiers
  
  // additional identifiers
  
  // additional identifiers
  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIFunctionClassifier::isMPI_Wait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp", line = 269,
   FQN="clang::ento::mpi::MPIFunctionClassifier::isMPI_Wait", NM="_ZNK5clang4ento3mpi21MPIFunctionClassifier10isMPI_WaitEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp -nm=_ZNK5clang4ento3mpi21MPIFunctionClassifier10isMPI_WaitEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public boolean isMPI_Wait(/*const*/ IdentifierInfo /*P*/ IdentInfo) /*const*/ {
    return IdentInfo == IdentInfo_MPI_Wait;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIFunctionClassifier::isMPI_Waitall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp", line = 273,
   FQN="clang::ento::mpi::MPIFunctionClassifier::isMPI_Waitall", NM="_ZNK5clang4ento3mpi21MPIFunctionClassifier13isMPI_WaitallEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp -nm=_ZNK5clang4ento3mpi21MPIFunctionClassifier13isMPI_WaitallEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public boolean isMPI_Waitall(/*const*/ IdentifierInfo /*P*/ IdentInfo) /*const*/ {
    return IdentInfo == IdentInfo_MPI_Waitall;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIFunctionClassifier::isWaitType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp", line = 278,
   FQN="clang::ento::mpi::MPIFunctionClassifier::isWaitType", NM="_ZNK5clang4ento3mpi21MPIFunctionClassifier10isWaitTypeEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp -nm=_ZNK5clang4ento3mpi21MPIFunctionClassifier10isWaitTypeEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public boolean isWaitType(/*const*/ IdentifierInfo /*P*/ IdentInfo) /*const*/ {
    return IdentInfo == IdentInfo_MPI_Wait || IdentInfo == IdentInfo_MPI_Waitall;
  }


/*private:*/
  // Initializes function identifiers, to recognize them during analysis.
  // Initializes function identifiers, to recognize them during analysis.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIFunctionClassifier::identifierInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp", line = 22,
   FQN="clang::ento::mpi::MPIFunctionClassifier::identifierInit", NM="_ZN5clang4ento3mpi21MPIFunctionClassifier14identifierInitERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp -nm=_ZN5clang4ento3mpi21MPIFunctionClassifier14identifierInitERNS_10ASTContextE")
  //</editor-fold>
  private void identifierInit(final ASTContext /*&*/ ASTCtx) {
    // Initialize function identifiers.
    initPointToPointIdentifiers(ASTCtx);
    initCollectiveIdentifiers(ASTCtx);
    initAdditionalIdentifiers(ASTCtx);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIFunctionClassifier::initPointToPointIdentifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp", line = 29,
   FQN="clang::ento::mpi::MPIFunctionClassifier::initPointToPointIdentifiers", NM="_ZN5clang4ento3mpi21MPIFunctionClassifier27initPointToPointIdentifiersERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp -nm=_ZN5clang4ento3mpi21MPIFunctionClassifier27initPointToPointIdentifiersERNS_10ASTContextE")
  //</editor-fold>
  private void initPointToPointIdentifiers(final ASTContext /*&*/ ASTCtx) {
    // Copy identifiers into the correct classification containers.
    IdentInfo_MPI_Send = $AddrOf(ASTCtx.Idents.get(new StringRef(/*KEEP_STR*/"MPI_Send")));
    MPIPointToPointTypes.push_back(IdentInfo_MPI_Send);
    MPIType.push_back(IdentInfo_MPI_Send);
    assert Native.$bool(IdentInfo_MPI_Send);
    
    IdentInfo_MPI_Isend = $AddrOf(ASTCtx.Idents.get(new StringRef(/*KEEP_STR*/"MPI_Isend")));
    MPIPointToPointTypes.push_back(IdentInfo_MPI_Isend);
    MPINonBlockingTypes.push_back(IdentInfo_MPI_Isend);
    MPIType.push_back(IdentInfo_MPI_Isend);
    assert Native.$bool(IdentInfo_MPI_Isend);
    
    IdentInfo_MPI_Ssend = $AddrOf(ASTCtx.Idents.get(new StringRef(/*KEEP_STR*/"MPI_Ssend")));
    MPIPointToPointTypes.push_back(IdentInfo_MPI_Ssend);
    MPIType.push_back(IdentInfo_MPI_Ssend);
    assert Native.$bool(IdentInfo_MPI_Ssend);
    
    IdentInfo_MPI_Issend = $AddrOf(ASTCtx.Idents.get(new StringRef(/*KEEP_STR*/"MPI_Issend")));
    MPIPointToPointTypes.push_back(IdentInfo_MPI_Issend);
    MPINonBlockingTypes.push_back(IdentInfo_MPI_Issend);
    MPIType.push_back(IdentInfo_MPI_Issend);
    assert Native.$bool(IdentInfo_MPI_Issend);
    
    IdentInfo_MPI_Bsend = $AddrOf(ASTCtx.Idents.get(new StringRef(/*KEEP_STR*/"MPI_Bsend")));
    MPIPointToPointTypes.push_back(IdentInfo_MPI_Bsend);
    MPIType.push_back(IdentInfo_MPI_Bsend);
    assert Native.$bool(IdentInfo_MPI_Bsend);
    
    IdentInfo_MPI_Ibsend = $AddrOf(ASTCtx.Idents.get(new StringRef(/*KEEP_STR*/"MPI_Ibsend")));
    MPIPointToPointTypes.push_back(IdentInfo_MPI_Ibsend);
    MPINonBlockingTypes.push_back(IdentInfo_MPI_Ibsend);
    MPIType.push_back(IdentInfo_MPI_Ibsend);
    assert Native.$bool(IdentInfo_MPI_Ibsend);
    
    IdentInfo_MPI_Rsend = $AddrOf(ASTCtx.Idents.get(new StringRef(/*KEEP_STR*/"MPI_Rsend")));
    MPIPointToPointTypes.push_back(IdentInfo_MPI_Rsend);
    MPIType.push_back(IdentInfo_MPI_Rsend);
    assert Native.$bool(IdentInfo_MPI_Rsend);
    
    IdentInfo_MPI_Irsend = $AddrOf(ASTCtx.Idents.get(new StringRef(/*KEEP_STR*/"MPI_Irsend")));
    MPIPointToPointTypes.push_back(IdentInfo_MPI_Irsend);
    MPIType.push_back(IdentInfo_MPI_Irsend);
    assert Native.$bool(IdentInfo_MPI_Irsend);
    
    IdentInfo_MPI_Recv = $AddrOf(ASTCtx.Idents.get(new StringRef(/*KEEP_STR*/"MPI_Recv")));
    MPIPointToPointTypes.push_back(IdentInfo_MPI_Recv);
    MPIType.push_back(IdentInfo_MPI_Recv);
    assert Native.$bool(IdentInfo_MPI_Recv);
    
    IdentInfo_MPI_Irecv = $AddrOf(ASTCtx.Idents.get(new StringRef(/*KEEP_STR*/"MPI_Irecv")));
    MPIPointToPointTypes.push_back(IdentInfo_MPI_Irecv);
    MPINonBlockingTypes.push_back(IdentInfo_MPI_Irecv);
    MPIType.push_back(IdentInfo_MPI_Irecv);
    assert Native.$bool(IdentInfo_MPI_Irecv);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIFunctionClassifier::initCollectiveIdentifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp", line = 86,
   FQN="clang::ento::mpi::MPIFunctionClassifier::initCollectiveIdentifiers", NM="_ZN5clang4ento3mpi21MPIFunctionClassifier25initCollectiveIdentifiersERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp -nm=_ZN5clang4ento3mpi21MPIFunctionClassifier25initCollectiveIdentifiersERNS_10ASTContextE")
  //</editor-fold>
  private void initCollectiveIdentifiers(final ASTContext /*&*/ ASTCtx) {
    // Copy identifiers into the correct classification containers.
    IdentInfo_MPI_Scatter = $AddrOf(ASTCtx.Idents.get(new StringRef(/*KEEP_STR*/"MPI_Scatter")));
    MPICollectiveTypes.push_back(IdentInfo_MPI_Scatter);
    MPIPointToCollTypes.push_back(IdentInfo_MPI_Scatter);
    MPIType.push_back(IdentInfo_MPI_Scatter);
    assert Native.$bool(IdentInfo_MPI_Scatter);
    
    IdentInfo_MPI_Iscatter = $AddrOf(ASTCtx.Idents.get(new StringRef(/*KEEP_STR*/"MPI_Iscatter")));
    MPICollectiveTypes.push_back(IdentInfo_MPI_Iscatter);
    MPIPointToCollTypes.push_back(IdentInfo_MPI_Iscatter);
    MPINonBlockingTypes.push_back(IdentInfo_MPI_Iscatter);
    MPIType.push_back(IdentInfo_MPI_Iscatter);
    assert Native.$bool(IdentInfo_MPI_Iscatter);
    
    IdentInfo_MPI_Gather = $AddrOf(ASTCtx.Idents.get(new StringRef(/*KEEP_STR*/"MPI_Gather")));
    MPICollectiveTypes.push_back(IdentInfo_MPI_Gather);
    MPICollToPointTypes.push_back(IdentInfo_MPI_Gather);
    MPIType.push_back(IdentInfo_MPI_Gather);
    assert Native.$bool(IdentInfo_MPI_Gather);
    
    IdentInfo_MPI_Igather = $AddrOf(ASTCtx.Idents.get(new StringRef(/*KEEP_STR*/"MPI_Igather")));
    MPICollectiveTypes.push_back(IdentInfo_MPI_Igather);
    MPICollToPointTypes.push_back(IdentInfo_MPI_Igather);
    MPINonBlockingTypes.push_back(IdentInfo_MPI_Igather);
    MPIType.push_back(IdentInfo_MPI_Igather);
    assert Native.$bool(IdentInfo_MPI_Igather);
    
    IdentInfo_MPI_Allgather = $AddrOf(ASTCtx.Idents.get(new StringRef(/*KEEP_STR*/"MPI_Allgather")));
    MPICollectiveTypes.push_back(IdentInfo_MPI_Allgather);
    MPICollToCollTypes.push_back(IdentInfo_MPI_Allgather);
    MPIType.push_back(IdentInfo_MPI_Allgather);
    assert Native.$bool(IdentInfo_MPI_Allgather);
    
    IdentInfo_MPI_Iallgather = $AddrOf(ASTCtx.Idents.get(new StringRef(/*KEEP_STR*/"MPI_Iallgather")));
    MPICollectiveTypes.push_back(IdentInfo_MPI_Iallgather);
    MPICollToCollTypes.push_back(IdentInfo_MPI_Iallgather);
    MPINonBlockingTypes.push_back(IdentInfo_MPI_Iallgather);
    MPIType.push_back(IdentInfo_MPI_Iallgather);
    assert Native.$bool(IdentInfo_MPI_Iallgather);
    
    IdentInfo_MPI_Bcast = $AddrOf(ASTCtx.Idents.get(new StringRef(/*KEEP_STR*/"MPI_Bcast")));
    MPICollectiveTypes.push_back(IdentInfo_MPI_Bcast);
    MPIPointToCollTypes.push_back(IdentInfo_MPI_Bcast);
    MPIType.push_back(IdentInfo_MPI_Bcast);
    assert Native.$bool(IdentInfo_MPI_Bcast);
    
    IdentInfo_MPI_Ibcast = $AddrOf(ASTCtx.Idents.get(new StringRef(/*KEEP_STR*/"MPI_Ibcast")));
    MPICollectiveTypes.push_back(IdentInfo_MPI_Ibcast);
    MPIPointToCollTypes.push_back(IdentInfo_MPI_Ibcast);
    MPINonBlockingTypes.push_back(IdentInfo_MPI_Ibcast);
    MPIType.push_back(IdentInfo_MPI_Ibcast);
    assert Native.$bool(IdentInfo_MPI_Ibcast);
    
    IdentInfo_MPI_Reduce = $AddrOf(ASTCtx.Idents.get(new StringRef(/*KEEP_STR*/"MPI_Reduce")));
    MPICollectiveTypes.push_back(IdentInfo_MPI_Reduce);
    MPICollToPointTypes.push_back(IdentInfo_MPI_Reduce);
    MPIType.push_back(IdentInfo_MPI_Reduce);
    assert Native.$bool(IdentInfo_MPI_Reduce);
    
    IdentInfo_MPI_Ireduce = $AddrOf(ASTCtx.Idents.get(new StringRef(/*KEEP_STR*/"MPI_Ireduce")));
    MPICollectiveTypes.push_back(IdentInfo_MPI_Ireduce);
    MPICollToPointTypes.push_back(IdentInfo_MPI_Ireduce);
    MPINonBlockingTypes.push_back(IdentInfo_MPI_Ireduce);
    MPIType.push_back(IdentInfo_MPI_Ireduce);
    assert Native.$bool(IdentInfo_MPI_Ireduce);
    
    IdentInfo_MPI_Allreduce = $AddrOf(ASTCtx.Idents.get(new StringRef(/*KEEP_STR*/"MPI_Allreduce")));
    MPICollectiveTypes.push_back(IdentInfo_MPI_Allreduce);
    MPICollToCollTypes.push_back(IdentInfo_MPI_Allreduce);
    MPIType.push_back(IdentInfo_MPI_Allreduce);
    assert Native.$bool(IdentInfo_MPI_Allreduce);
    
    IdentInfo_MPI_Iallreduce = $AddrOf(ASTCtx.Idents.get(new StringRef(/*KEEP_STR*/"MPI_Iallreduce")));
    MPICollectiveTypes.push_back(IdentInfo_MPI_Iallreduce);
    MPICollToCollTypes.push_back(IdentInfo_MPI_Iallreduce);
    MPINonBlockingTypes.push_back(IdentInfo_MPI_Iallreduce);
    MPIType.push_back(IdentInfo_MPI_Iallreduce);
    assert Native.$bool(IdentInfo_MPI_Iallreduce);
    
    IdentInfo_MPI_Alltoall = $AddrOf(ASTCtx.Idents.get(new StringRef(/*KEEP_STR*/"MPI_Alltoall")));
    MPICollectiveTypes.push_back(IdentInfo_MPI_Alltoall);
    MPICollToCollTypes.push_back(IdentInfo_MPI_Alltoall);
    MPIType.push_back(IdentInfo_MPI_Alltoall);
    assert Native.$bool(IdentInfo_MPI_Alltoall);
    
    IdentInfo_MPI_Ialltoall = $AddrOf(ASTCtx.Idents.get(new StringRef(/*KEEP_STR*/"MPI_Ialltoall")));
    MPICollectiveTypes.push_back(IdentInfo_MPI_Ialltoall);
    MPICollToCollTypes.push_back(IdentInfo_MPI_Ialltoall);
    MPINonBlockingTypes.push_back(IdentInfo_MPI_Ialltoall);
    MPIType.push_back(IdentInfo_MPI_Ialltoall);
    assert Native.$bool(IdentInfo_MPI_Ialltoall);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIFunctionClassifier::initAdditionalIdentifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp", line = 180,
   FQN="clang::ento::mpi::MPIFunctionClassifier::initAdditionalIdentifiers", NM="_ZN5clang4ento3mpi21MPIFunctionClassifier25initAdditionalIdentifiersERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.cpp -nm=_ZN5clang4ento3mpi21MPIFunctionClassifier25initAdditionalIdentifiersERNS_10ASTContextE")
  //</editor-fold>
  private void initAdditionalIdentifiers(final ASTContext /*&*/ ASTCtx) {
    IdentInfo_MPI_Comm_rank = $AddrOf(ASTCtx.Idents.get(new StringRef(/*KEEP_STR*/"MPI_Comm_rank")));
    MPIType.push_back(IdentInfo_MPI_Comm_rank);
    assert Native.$bool(IdentInfo_MPI_Comm_rank);
    
    IdentInfo_MPI_Comm_size = $AddrOf(ASTCtx.Idents.get(new StringRef(/*KEEP_STR*/"MPI_Comm_size")));
    MPIType.push_back(IdentInfo_MPI_Comm_size);
    assert Native.$bool(IdentInfo_MPI_Comm_size);
    
    IdentInfo_MPI_Wait = $AddrOf(ASTCtx.Idents.get(new StringRef(/*KEEP_STR*/"MPI_Wait")));
    MPIType.push_back(IdentInfo_MPI_Wait);
    assert Native.$bool(IdentInfo_MPI_Wait);
    
    IdentInfo_MPI_Waitall = $AddrOf(ASTCtx.Idents.get(new StringRef(/*KEEP_STR*/"MPI_Waitall")));
    MPIType.push_back(IdentInfo_MPI_Waitall);
    assert Native.$bool(IdentInfo_MPI_Waitall);
    
    IdentInfo_MPI_Barrier = $AddrOf(ASTCtx.Idents.get(new StringRef(/*KEEP_STR*/"MPI_Barrier")));
    MPICollectiveTypes.push_back(IdentInfo_MPI_Barrier);
    MPIType.push_back(IdentInfo_MPI_Barrier);
    assert Native.$bool(IdentInfo_MPI_Barrier);
  }


  
  // The containers are used, to enable classification of MPI-functions during
  // analysis.
  private SmallVector<IdentifierInfo /*P*/> MPINonBlockingTypes;
  
  private SmallVector<IdentifierInfo /*P*/> MPIPointToPointTypes;
  private SmallVector<IdentifierInfo /*P*/> MPICollectiveTypes;
  
  private SmallVector<IdentifierInfo /*P*/> MPIPointToCollTypes;
  private SmallVector<IdentifierInfo /*P*/> MPICollToPointTypes;
  private SmallVector<IdentifierInfo /*P*/> MPICollToCollTypes;
  
  private SmallVector<IdentifierInfo /*P*/> MPIType;
  
  // point-to-point functions
  private IdentifierInfo /*P*/ IdentInfo_MPI_Send/* = null*/;
  private IdentifierInfo /*P*/ IdentInfo_MPI_Isend/* = null*/;
  private IdentifierInfo /*P*/ IdentInfo_MPI_Ssend/* = null*/;
  private IdentifierInfo /*P*/ IdentInfo_MPI_Issend/* = null*/;
  private IdentifierInfo /*P*/ IdentInfo_MPI_Bsend/* = null*/;
  private IdentifierInfo /*P*/ IdentInfo_MPI_Ibsend/* = null*/;
  private IdentifierInfo /*P*/ IdentInfo_MPI_Rsend/* = null*/;
  private IdentifierInfo /*P*/ IdentInfo_MPI_Irsend/* = null*/;
  private IdentifierInfo /*P*/ IdentInfo_MPI_Recv/* = null*/;
  private IdentifierInfo /*P*/ IdentInfo_MPI_Irecv/* = null*/;
  
  // collective functions
  private IdentifierInfo /*P*/ IdentInfo_MPI_Scatter/* = null*/;
  private IdentifierInfo /*P*/ IdentInfo_MPI_Iscatter/* = null*/;
  private IdentifierInfo /*P*/ IdentInfo_MPI_Gather/* = null*/;
  private IdentifierInfo /*P*/ IdentInfo_MPI_Igather/* = null*/;
  private IdentifierInfo /*P*/ IdentInfo_MPI_Allgather/* = null*/;
  private IdentifierInfo /*P*/ IdentInfo_MPI_Iallgather/* = null*/;
  private IdentifierInfo /*P*/ IdentInfo_MPI_Bcast/* = null*/;
  private IdentifierInfo /*P*/ IdentInfo_MPI_Ibcast/* = null*/;
  private IdentifierInfo /*P*/ IdentInfo_MPI_Reduce/* = null*/;
  private IdentifierInfo /*P*/ IdentInfo_MPI_Ireduce/* = null*/;
  private IdentifierInfo /*P*/ IdentInfo_MPI_Allreduce/* = null*/;
  private IdentifierInfo /*P*/ IdentInfo_MPI_Iallreduce/* = null*/;
  private IdentifierInfo /*P*/ IdentInfo_MPI_Alltoall/* = null*/;
  private IdentifierInfo /*P*/ IdentInfo_MPI_Ialltoall/* = null*/;
  private IdentifierInfo /*P*/ IdentInfo_MPI_Barrier/* = null*/;
  
  // additional functions
  private IdentifierInfo /*P*/ IdentInfo_MPI_Comm_rank/* = null*/;
  private IdentifierInfo /*P*/ IdentInfo_MPI_Comm_size/* = null*/;
  private IdentifierInfo /*P*/ IdentInfo_MPI_Wait/* = null*/;
  private IdentifierInfo /*P*/ IdentInfo_MPI_Waitall/* = null*/;
  //<editor-fold defaultstate="collapsed" desc="clang::ento::mpi::MPIFunctionClassifier::~MPIFunctionClassifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIFunctionClassifier.h", line = 24,
   FQN="clang::ento::mpi::MPIFunctionClassifier::~MPIFunctionClassifier", NM="_ZN5clang4ento3mpi21MPIFunctionClassifierD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MPI-Checker/MPIBugReporter.cpp -nm=_ZN5clang4ento3mpi21MPIFunctionClassifierD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    MPIType.$destroy();
    MPICollToCollTypes.$destroy();
    MPICollToPointTypes.$destroy();
    MPIPointToCollTypes.$destroy();
    MPICollectiveTypes.$destroy();
    MPIPointToPointTypes.$destroy();
    MPINonBlockingTypes.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "MPINonBlockingTypes=" + MPINonBlockingTypes // NOI18N
              + ", MPIPointToPointTypes=" + MPIPointToPointTypes // NOI18N
              + ", MPICollectiveTypes=" + MPICollectiveTypes // NOI18N
              + ", MPIPointToCollTypes=" + MPIPointToCollTypes // NOI18N
              + ", MPICollToPointTypes=" + MPICollToPointTypes // NOI18N
              + ", MPICollToCollTypes=" + MPICollToCollTypes // NOI18N
              + ", MPIType=" + MPIType // NOI18N
              + ", IdentInfo_MPI_Send=" + IdentInfo_MPI_Send // NOI18N
              + ", IdentInfo_MPI_Isend=" + IdentInfo_MPI_Isend // NOI18N
              + ", IdentInfo_MPI_Ssend=" + IdentInfo_MPI_Ssend // NOI18N
              + ", IdentInfo_MPI_Issend=" + IdentInfo_MPI_Issend // NOI18N
              + ", IdentInfo_MPI_Bsend=" + IdentInfo_MPI_Bsend // NOI18N
              + ", IdentInfo_MPI_Ibsend=" + IdentInfo_MPI_Ibsend // NOI18N
              + ", IdentInfo_MPI_Rsend=" + IdentInfo_MPI_Rsend // NOI18N
              + ", IdentInfo_MPI_Irsend=" + IdentInfo_MPI_Irsend // NOI18N
              + ", IdentInfo_MPI_Recv=" + IdentInfo_MPI_Recv // NOI18N
              + ", IdentInfo_MPI_Irecv=" + IdentInfo_MPI_Irecv // NOI18N
              + ", IdentInfo_MPI_Scatter=" + IdentInfo_MPI_Scatter // NOI18N
              + ", IdentInfo_MPI_Iscatter=" + IdentInfo_MPI_Iscatter // NOI18N
              + ", IdentInfo_MPI_Gather=" + IdentInfo_MPI_Gather // NOI18N
              + ", IdentInfo_MPI_Igather=" + IdentInfo_MPI_Igather // NOI18N
              + ", IdentInfo_MPI_Allgather=" + IdentInfo_MPI_Allgather // NOI18N
              + ", IdentInfo_MPI_Iallgather=" + IdentInfo_MPI_Iallgather // NOI18N
              + ", IdentInfo_MPI_Bcast=" + IdentInfo_MPI_Bcast // NOI18N
              + ", IdentInfo_MPI_Ibcast=" + IdentInfo_MPI_Ibcast // NOI18N
              + ", IdentInfo_MPI_Reduce=" + IdentInfo_MPI_Reduce // NOI18N
              + ", IdentInfo_MPI_Ireduce=" + IdentInfo_MPI_Ireduce // NOI18N
              + ", IdentInfo_MPI_Allreduce=" + IdentInfo_MPI_Allreduce // NOI18N
              + ", IdentInfo_MPI_Iallreduce=" + IdentInfo_MPI_Iallreduce // NOI18N
              + ", IdentInfo_MPI_Alltoall=" + IdentInfo_MPI_Alltoall // NOI18N
              + ", IdentInfo_MPI_Ialltoall=" + IdentInfo_MPI_Ialltoall // NOI18N
              + ", IdentInfo_MPI_Barrier=" + IdentInfo_MPI_Barrier // NOI18N
              + ", IdentInfo_MPI_Comm_rank=" + IdentInfo_MPI_Comm_rank // NOI18N
              + ", IdentInfo_MPI_Comm_size=" + IdentInfo_MPI_Comm_size // NOI18N
              + ", IdentInfo_MPI_Wait=" + IdentInfo_MPI_Wait // NOI18N
              + ", IdentInfo_MPI_Waitall=" + IdentInfo_MPI_Waitall; // NOI18N
  }
}
